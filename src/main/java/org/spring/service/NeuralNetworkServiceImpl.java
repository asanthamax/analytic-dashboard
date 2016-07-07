package org.spring.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.dao.NeuralNetworkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 7/6/16.
 */
@Service("neuralNetworkService")
public class NeuralNetworkServiceImpl implements NeuralNetworkService {

    private Log log = LogFactory.getLog(NeuralNetworkServiceImpl.class);
    private String uploadDirectory = "/datasets";
    @Autowired
    private NeuralNetworkDAO neuralNetworkDAO;

    @Override
    public boolean addDataset(List<String> files) {

        if(neuralNetworkDAO.addDataSet(files)){

            return true;
        }else{

            return false;
        }
    }


    @Override
    public List<String> uploadDataset(MultipartFile[] files) {

        List<String> status = new ArrayList<String>();
        if(files.length!=0){

            for(MultipartFile file : files){

                String name = file.getOriginalFilename();
                try{

                    byte[] bytes = file.getBytes();
                    File directory = new File(uploadDirectory,File.separator+"tmpFiles");
                    if(!directory.exists()){

                        directory.mkdir();
                    }
                    File uploadedFile = new File(directory.getAbsolutePath(),File.separator+name);
                    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                    outputStream.write(bytes);
                    outputStream.close();
                    log.info("Dataset Successfully Uploaded to :"+uploadedFile.getAbsolutePath());
                    status.add(uploadedFile.getAbsolutePath());
                }catch(Exception e){

                    log.error("Error Occurred while uploading file:"+e.getLocalizedMessage());
                }
            }
        }else{

            log.error("Cannot Upload dataset file is empty");
        }
        return status;
    }

    @Override
    public void removeDataset(int id) {

    }

    @Override
    public Map<String, Object> getAllDataSets() {
        return null;
    }
}
