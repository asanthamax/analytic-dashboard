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
import org.deeplearning4j.nn.conf.layers.*;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.api.IterationListener;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.spark.impl.multilayer.SparkDl4jMultiLayer;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.util.Collections;

/**
 * Deep Convolutional Neural Network to detect frauds.
 */
public class FraudDetectorNeuralNet {

    private static final Log log = LogFactory.getLog(FraudDetectorNeuralNet.class);
    private int nChannels = 1;
    private int outputNum = 3;
    private int batchSize = 64;
    private int nEpochs = 10;
    private int iterations = 1;
    private int seed = 123;
    private DataSetIterator minTrainSet;
    private MultiLayerNetwork model = null;

    public FraudDetectorNeuralNet(){



    }

    public void buildModel() throws NeuralException {

        log.info("load model....");
        try {
            log.info("build model...");
            MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                    .seed(12345)
                    .iterations(iterations)
                    .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                    .learningRate(0.001)
                    .l1(0.01).regularization(true).l2(1e-3)
                    .list()
                    .layer(0, new DenseLayer.Builder().nIn(38).nOut(3)
                            .activation("tanh")
                            .weightInit(WeightInit.XAVIER)
                            .build())
                    .layer(1, new DenseLayer.Builder().nIn(3).nOut(2)
                            .activation("tanh")
                            .weightInit(WeightInit.XAVIER)
                            .build())
                    .layer(2, new OutputLayer.Builder(LossFunctions.LossFunction.MCXENT)
                            .weightInit(WeightInit.XAVIER)
                            .activation("softmax")
                            .nIn(2).nOut(outputNum).build())
                    .backprop(true).pretrain(false)
                    .build();

            model = new MultiLayerNetwork(conf);
            model.init();
            //model.setUpdater(Updater.ADAGRAD);
        } catch (Exception e) {
            log.error("Error ocuured while building neural netowrk :"+e.getMessage());
            throw new NeuralException(e.getLocalizedMessage(),e);
        }
    }

    public void trainModel() throws NeuralException {

        try {
            RecordReader recordReader = new CSVRecordReader(0,",");
            SparkDataSet sparkDataSet = SparkDataSet.getInstance("fraud_data","local[*]",38,3);
            JavaRDD<DataSet> rddDataSet = sparkDataSet.generateTrainingDataset("hdfs://localhost:9000/user/asantha/fraud_data/fraud_dataset.csv");
            log.info("Train model...");
            if(model== null){

                buildModel();
            }
            model.setListeners(Collections.singletonList((IterationListener) new ScoreIterationListener(1/5)));
            SparkDl4jMultiLayer network = new SparkDl4jMultiLayer(sparkDataSet.getSc(),model);
            network.fitDataSet(rddDataSet);
        } catch (Exception e) {

            log.error("Error ocuured while building neural netowrk :"+e.getMessage());
            throw new NeuralException(e.getLocalizedMessage(),e);
        }
    }

    public void detectFraud(DataSet input) throws NeuralException {

        if(model == null){

            buildModel();
        }
        log.info("output :"+model.output(input.getLabels()));
    }

    public static void main(String[] args) {

        FraudDetectorNeuralNet model = new FraudDetectorNeuralNet();
        try {
            model.buildModel();
            model.trainModel();
        } catch (NeuralException e) {
            e.printStackTrace();
        }
    }


}
