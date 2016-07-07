package org.analytic.dashboard;

import org.spring.service.NeuralNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 7/6/16.
 */
@Controller
public class NeuralNetworkGeneratorController {

    @Autowired
    private NeuralNetworkService neuralNetworkService;

    @RequestMapping(value = "/generate_model" ,method= RequestMethod.POST)
    public void generateNeuralNetwork(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String className = request.getParameter("packagename");
        int columns = Integer.parseInt(request.getParameter("ccolumns"));
        int outputs = Integer.parseInt(request.getParameter("coutputs"));
        //neuralNetworkGeneratorService.generateModel(className,columns,outputs);
        response.sendRedirect("/getNN");
    }

    @RequestMapping(value="/getNN",method= RequestMethod.GET)
    public String getAllNN(){

        /*Map<String,Object> neuralNetworks = neuralNetworkGeneratorService.getAllNN();
        ModelAndView model = new ModelAndView();
        model.addObject("neural_networks",neuralNetworks);*/
        return "neural_network";
    }

    @RequestMapping(value="/add_dataset",method=RequestMethod.GET)
    public String addNewDataSet(){

        return "nn_dataset";
    }

    @RequestMapping(value="/upload_dataset",method=RequestMethod.POST)
    public void uploadDataSet(@RequestParam("dataset_type") String type,@RequestParam("files") MultipartFile[] files){

        String dataset_status = type;
        if(dataset_status.equals("qualified")){

            List<String> uploadedFiles = neuralNetworkService.uploadDataset(files);
            if(!uploadedFiles.isEmpty()){

                neuralNetworkService.addDataset(uploadedFiles);
            }
        }
        else{


        }
    }
}
