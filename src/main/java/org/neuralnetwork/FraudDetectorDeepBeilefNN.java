package org.neuralnetwork;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.spark.api.java.JavaRDD;
import org.canova.api.records.reader.RecordReader;
import org.canova.api.records.reader.impl.CSVRecordReader;
import org.canova.api.split.FileSplit;
import org.deeplearning4j.datasets.canova.RecordReaderDataSetIterator;
import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.*;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.api.IterationListener;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.spark.api.Repartition;
import org.deeplearning4j.spark.api.RepartitionStrategy;
import org.deeplearning4j.spark.api.stats.SparkTrainingStats;
import org.deeplearning4j.spark.impl.multilayer.SparkDl4jMultiLayer;
import org.deeplearning4j.spark.impl.paramavg.ParameterAveragingTrainingMaster;
import org.deeplearning4j.spark.stats.StatsUtils;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

/**
 * Deep Belif Neural Network to detect frauds.
 */
public class FraudDetectorDeepBeilefNN {

    private static final Log log = LogFactory.getLog(FraudDetectorNeuralNet.class);
    private int outputNum = 3;
    private int iterations = 4;
    private int seed = 1234;
    private MultiLayerNetwork model = null;
    private int HIDDEN_LAYER_COUNT = 4;
    private int numHiddenNodes = 20;
    private String uploadDirectory;

    public FraudDetectorDeepBeilefNN(){


    }

    public void buildModel(){

        log.info("Build model....");
        NeuralNetConfiguration.Builder builder = new NeuralNetConfiguration.Builder();
        builder.iterations(iterations);
        builder.learningRate(0.001);
       // builder.momentum(0.01);
        builder.optimizationAlgo(OptimizationAlgorithm.CONJUGATE_GRADIENT);
        builder.seed(seed);
        builder.biasInit(1);
        builder.regularization(true).l2(1e-5);
        builder.updater(Updater.RMSPROP);
        builder.weightInit(WeightInit.RELU);
        NeuralNetConfiguration.ListBuilder list = builder.list();

        for(int i=0;i<HIDDEN_LAYER_COUNT;i++){

            GravesBidirectionalLSTM.Builder hiddenLayerBuilder = new GravesBidirectionalLSTM.Builder();
            hiddenLayerBuilder.nIn(i==0 ? 4 : numHiddenNodes);
            hiddenLayerBuilder.nOut(numHiddenNodes);
            hiddenLayerBuilder.activation("relu");
            list.layer(i,hiddenLayerBuilder.build());
        }

        RnnOutputLayer.Builder outputLayer = new RnnOutputLayer.Builder(LossFunction.NEGATIVELOGLIKELIHOOD);
        outputLayer.activation("softmax");
        outputLayer.nIn(numHiddenNodes);
        outputLayer.nOut(2);
        list.layer(HIDDEN_LAYER_COUNT,outputLayer.build());
        list.pretrain(false);
        list.backprop(true);
        MultiLayerConfiguration configuration = list.build();
        model = new MultiLayerNetwork(configuration);
        model.init();
        model.setListeners(new ScoreIterationListener(1));

    }

    public String trainModel(/*String neural_model, JavaRDD<org.nd4j.linalg.dataset.DataSet> rddDataSet, SparkDataSet sparkDataSet*/) throws NeuralException {

        try {
            SparkDataSet sparkDataSet = SparkDataSet.getInstance("fraud_data","local[*]",0,2);
            JavaRDD<org.nd4j.linalg.dataset.DataSet> rddDataSet = sparkDataSet.generateTrainingDataset("datasample.csv");
            log.info("Training model...");
          //  loadSaveNN(neural_model,false);
            if(model== null){

                buildModel();
            }
            //setup the spark training
            ParameterAveragingTrainingMaster tm = new ParameterAveragingTrainingMaster.Builder(1)
                    .workerPrefetchNumBatches(2) //Asynchronusly prefetch upto 2 batches
                    .saveUpdater(true)
                    .repartionData(Repartition.Always)
                    .repartitionStrategy(RepartitionStrategy.Balanced)
                    .batchSizePerWorker(8) //number of examples that each worket gets,per fit operation
                    .build();
            SparkDl4jMultiLayer network = new SparkDl4jMultiLayer(sparkDataSet.getSc(),model,tm);
            network.setCollectTrainingStats(true);
            int nEpochs = 50;
            for(int i=0;i<nEpochs;i++){

                model = network.fit(rddDataSet);
            }
            SparkTrainingStats stats = network.getSparkTrainingStats();
            StatsUtils.exportStatsAsHtml(stats,"SparkTrainingStatus.html",sparkDataSet.getSc());
            Evaluation evaluation = network.evaluate(rddDataSet);
            String statMsg = evaluation.stats();
            log.info(statMsg);
            //loadSaveNN(neural_model,true);
            return statMsg;

        } catch (Exception e) {

            log.error("Error ocuured while building neural netowrk :"+e.getMessage());
            throw new NeuralException(e.getLocalizedMessage(),e);
        }
    }

    private void loadSaveNN(String name,boolean save){


        File directory = new File(uploadDirectory);
        File[] allNN = directory.listFiles();
        boolean status = false;
        try {

            if(model == null && save){

                buildModel();
            }
            if(allNN != null && allNN.length > 0) {
                for (File NN : allNN) {

                    String fnme = FilenameUtils.removeExtension(NN.getName());
                    if (NN.getName().equals(fnme)) {

                        status = true;
                        if (save) {

                            ModelSerializer.writeModel(model,NN,true);

                        } else {

                            model = ModelSerializer.restoreMultiLayerNetwork(NN);
                        }
                        break;
                    }
                }
            }
            if(!status && save){

                //File tempFIle = File.createTempFile(name,".zip",directory);
                File tempFile = new File(directory.getAbsolutePath()+"/"+name+".zip");
                if(!tempFile.exists()){

                    tempFile.createNewFile();
                }
                ModelSerializer.writeModel(model,tempFile,true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testModel() throws IOException{

        if(model == null){

            buildModel();
           // trainModel();
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

    public void setUploadDirectory(String uploadDirectory) {

        this.uploadDirectory = uploadDirectory;

    }

    public static void main(String[] args) {

        FraudDetectorDeepBeilefNN neural_network = new FraudDetectorDeepBeilefNN();
        try {
            neural_network.buildModel();
            String output = neural_network.trainModel();
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
