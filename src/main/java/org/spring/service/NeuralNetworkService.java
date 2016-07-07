package org.spring.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 7/6/16.
 */
public interface NeuralNetworkService {

    boolean addDataset(List<String> files);

    List<String> uploadDataset(MultipartFile[] file);

    void removeDataset(int id);

    Map<String,Object> getAllDataSets();
}
