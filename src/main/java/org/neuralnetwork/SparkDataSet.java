package org.neuralnetwork;

import org.canova.api.records.reader.RecordReader;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.canova.api.records.reader.impl.CSVRecordReader;
import org.deeplearning4j.spark.canova.RecordReaderFunction;
import org.nd4j.linalg.dataset.DataSet;

/**
 * Created by asantha on 7/4/16.
 */
public class SparkDataSet {

    private SparkConf conf;
    private JavaSparkContext sc;
    private RecordReader recordReader;
    private int labelIndex;
    private int numOutPutClasses;
    private static SparkDataSet sparkDataSet = null;

    private SparkDataSet(String sparkAppName,String master,int labels,int output){

        conf = new SparkConf().setAppName(sparkAppName).setMaster(master);
        setSc(new JavaSparkContext(conf));
        recordReader = new CSVRecordReader(0,",");
        labelIndex = labels;
        numOutPutClasses = output;
    }

    public JavaRDD<DataSet> generateTrainingDataset(String hdfs_url) {

        JavaRDD<String> distFile = getSc().textFile(hdfs_url);
        JavaRDD<DataSet> trainingData = distFile.map(new RecordReaderFunction(recordReader, labelIndex, numOutPutClasses));
        return trainingData;
    }

    public static SparkDataSet getInstance(String sparkAppName,String master,int labels,int outputs){

        if(sparkDataSet == null){

            sparkDataSet = new SparkDataSet(sparkAppName,master,labels,outputs);
        }
        return sparkDataSet;
    }

    public JavaSparkContext getSc() {
        return sc;
    }

    public void setSc(JavaSparkContext sc) {
        this.sc = sc;
    }
}
