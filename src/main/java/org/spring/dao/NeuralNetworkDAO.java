package org.spring.dao;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by asantha on 7/6/16.
 */
public interface NeuralNetworkDAO {

    boolean addDataSet(List<String> file);

    void removeDataSet(String fileName);

    List<String> getAllDatasets();
}
