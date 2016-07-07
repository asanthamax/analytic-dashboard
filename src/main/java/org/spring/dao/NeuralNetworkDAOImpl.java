package org.spring.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csv.bulkimport.CSVStore;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 7/6/16.
 */
@Repository("neuralNetowrkDAO")
public class NeuralNetworkDAOImpl implements NeuralNetworkDAO {

    private Log log = LogFactory.getLog(NeuralNetworkDAOImpl.class);
    @Override
    public boolean addDataSet(List<String> files) {

        boolean status = false;
        for(String file:files) {
            try {

                CSVStore store = new CSVStore(file);
                Map<String,ArrayList<String>> groupings = store.determineGrouping();
                store.insertObjects(groupings);
                status = true;
                log.info("CSV file added to DB successfully:"+file);
            } catch (IOException e) {

                status=false;
                log.error("Error ocuured while adding csv:"+file);
            }
        }
        return status;
    }

    @Override
    public void removeDataSet(String fileName) {

    }

    @Override
    public List<String> getAllDatasets() {
        return null;
    }
}
