package org.neuralnetwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.spark.api.java.JavaRDD;
import org.canova.api.records.reader.RecordReader;
import org.canova.api.records.reader.impl.CSVRecordReader;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.ConvolutionLayer;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.conf.layers.setup.ConvolutionLayerSetup;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.spark.impl.multilayer.SparkDl4jMultiLayer;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.util.Collections;

/**
 * Convolutional Neural Network.
 */
public class FraudDetectorConNet {

    private static final Log log = LogFactory.getLog(FraudDetectorConNet.class);
    private int nChannels = 3;
    private int outputNum = 3;
    private int batchSize = 64;
    private int nEpochs = 10;
    private int iterations = 1;
    private int seed = 123;
    private DataSetIterator minTrainSet;
    private MultiLayerNetwork model = null;

    public FraudDetectorConNet(){


    }

    public void buildModel() throws NeuralException{

        log.info("load Model...");
        try{

            MultiLayerConfiguration.Builder builder = new NeuralNetConfiguration.Builder()
                    .seed(seed)
                    .iterations(iterations)
                    .regularization(true).l2(0.0005)
                    .learningRate(0.1)
                    .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                    .updater(Updater.ADAGRAD)
                    .list()
                    .layer(0,new ConvolutionLayer.Builder(5,5)
                            .nIn(nChannels)
                            .stride(1,1)
                            .nOut(3)
                            .activation("identity")
                            .build())
                    .layer(1,new ConvolutionLayer.Builder(5,5)
                            .nIn(3)
                            .nOut(2)
                            .stride(2,2)
                            .activation("identity")
                            .build())
                    .layer(2,new DenseLayer.Builder().activation("relu")
                            .nOut(200).build())
                    .layer(3,new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                            .nOut(outputNum)
                            .activation("softmax")
                            .build())
                    .backprop(true)
                    .pretrain(false);
            new ConvolutionLayerSetup(builder,38,192,nChannels);
            MultiLayerConfiguration conf = builder.build();
            model = new MultiLayerNetwork(conf);
            model.init();
        }catch(Exception e){
            log.error("Error ocuured while building neural netowrk :"+e.getMessage());
            throw new NeuralException(e.getLocalizedMessage(),e);
        }
    }

    public void trainModel() throws NeuralException{

        try {
            RecordReader recordReader = new CSVRecordReader(0,",");
            SparkDataSet sparkDataSet = SparkDataSet.getInstance("fraud_data","local[*]",38,3);
            JavaRDD<DataSet> rddDataSet = sparkDataSet.generateTrainingDataset("hdfs://localhost:9000/user/asantha/fraud_data/fraud_dataset.csv");
            log.info("Train model...");
            if(model== null){

                buildModel();
            }
            model.setListeners(new ScoreIterationListener(1));
            SparkDl4jMultiLayer network = new SparkDl4jMultiLayer(sparkDataSet.getSc(),model);
            network.fitDataSet(rddDataSet);
        } catch (Exception e) {

            log.error("Error ocuured while building neural netowrk :"+e.getMessage());
            throw new NeuralException(e.getLocalizedMessage(),e);
        }
    }

    public void detectFraud(DataSet dataSet) throws NeuralException{

        if(model == null){

            buildModel();
        }
        log.info("output :"+model.output(dataSet.getLabels()));
    }

    public static void main(String[] args) {

        FraudDetectorConNet model = new FraudDetectorConNet();
        try {

            model.buildModel();
            model.trainModel();
        } catch (NeuralException e) {

            log.error("Error Occurred:"+e.getMessage());
        }
    }
}
