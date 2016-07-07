package org.neuralnetwork;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.spark.api.java.JavaRDD;
import org.canova.api.records.reader.RecordReader;
import org.canova.api.records.reader.impl.CSVRecordReader;
import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.conf.layers.RBM;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.api.IterationListener;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.spark.impl.multilayer.SparkDl4jMultiLayer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;

import java.io.IOException;
import java.util.Collections;

/**
 * Deep Belif Neural Network to detect frauds.
 */
public class FraudDetectorDeepBeilefNN {

    private static final Log log = LogFactory.getLog(FraudDetectorNeuralNet.class);
    private int nChannels = 1;
    private int outputNum = 3;
    private int batchSize = 64;
    private int numSamples = 60000;
    private int nEpochs = 10;
    private int iterations = 1;
    private int seed = 123;
    private DataSetIterator minTrainSet;
    private MultiLayerNetwork model = null;
    private int numRows = 1;
    private int numColumns = 38;
    private int listenerFreq = iterations / 5;

    public FraudDetectorDeepBeilefNN(){


    }

    public void buildModel(){

        log.info("Build model....");
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(seed)
                .iterations(iterations)
                .optimizationAlgo(OptimizationAlgorithm.LINE_GRADIENT_DESCENT)
                .list()
                .layer(0, new RBM.Builder().nIn(numRows*numColumns).nOut(100)
                        .lossFunction(LossFunction.RMSE_XENT)
                        .build())
                .layer(1, new RBM.Builder().nIn(100).nOut(50)
                        .lossFunction(LossFunction.RMSE_XENT)
                        .build())
                .layer(2, new RBM.Builder().nIn(50).nOut(20)
                        .lossFunction(LossFunction.RMSE_XENT)
                        .build())
                .layer(3, new RBM.Builder().nIn(20).nOut(10)
                        .lossFunction(LossFunction.RMSE_XENT)
                        .build())
                .layer(4, new RBM.Builder().nIn(10).nOut(3)
                        .lossFunction(LossFunction.RMSE_XENT)
                        .build())
                .layer(5, new RBM.Builder().nIn(3).nOut(10)
                        .lossFunction(LossFunction.RMSE_XENT)
                        .build())
                .layer(6, new RBM.Builder().nIn(10).nOut(20)
                        .lossFunction(LossFunction.RMSE_XENT)
                        .build())
                .layer(7, new RBM.Builder().nIn(20).nOut(50)
                        .lossFunction(LossFunction.RMSE_XENT)
                        .build())
                .layer(8, new RBM.Builder().nIn(50).nOut(100)
                        .lossFunction(LossFunction.RMSE_XENT)
                        .build())
                .layer(9, new OutputLayer.Builder(LossFunction.RMSE_XENT).activation("softmax")
                        .nIn(100).nOut(numRows*numColumns).build())
                .pretrain(true).backprop(true)
                .build();

        model = new MultiLayerNetwork(conf);
        model.init();
    }

    public void trainModel() throws IOException {

        RecordReader recordReader = new CSVRecordReader(0,",");
        SparkDataSet sparkDataSet = SparkDataSet.getInstance("fraud_data","local[*]",38,3);
        JavaRDD<org.nd4j.linalg.dataset.DataSet> rddDataSet = sparkDataSet.generateTrainingDataset("hdfs://localhost:9000/user/asantha/fraud_data/fraud_dataset.csv");
        log.info("Train model...");
        if(model== null){

            buildModel();
        }
        model.setListeners(Collections.singletonList((IterationListener) new ScoreIterationListener(listenerFreq)));
        SparkDl4jMultiLayer network = new SparkDl4jMultiLayer(sparkDataSet.getSc(),model);
        network.fitDataSet(rddDataSet);
    }

    public void testModel() throws IOException{

        if(model == null){

            buildModel();
            trainModel();
        }
        log.info("Evaluate model....");
        Evaluation eval = new Evaluation(outputNum);

        DataSetIterator testIter = new MnistDataSetIterator(100,10000);
        while(testIter.hasNext()) {
            DataSet testMnist = testIter.next();
            INDArray predict2 = model.output(testMnist.getFeatureMatrix());
            eval.eval(testMnist.getLabels(), predict2);
        }

        log.info(eval.stats());
        log.info("****************Example finished********************");

    }

    public static void main(String[] args) {

        FraudDetectorDeepBeilefNN neural_network = new FraudDetectorDeepBeilefNN();
        try {
            neural_network.testModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
