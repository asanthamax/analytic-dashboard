package org.spring.ws;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by asantha on 6/15/16.
 */
public class WebServiceClient {

    private static final String URL = "http://localhost:8080/service/xml/webservice/updateUser";

    public static void main(String[] args) throws Exception{

        try{

            Client client = Client.create();
            WebResource resource = client.resource(URL);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userID",1);
            jsonObject.put("userName","Asantha");
            jsonObject.put("longitude",1.3123131);
            jsonObject.put("latitude",-1.2343222);
            jsonObject.put("date",new Date());
            ClientResponse response = resource.accept(MediaType.TEXT_PLAIN).post(ClientResponse.class,jsonObject);
            if(response.getStatus() != 200){

                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            else{

                System.out.println(response);
            }

        }catch (Exception e){

            e.printStackTrace();
        }
    }
}
