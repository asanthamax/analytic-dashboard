package org.spring.ws;

import org.json.JSONObject;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;
import java.net.URL;
import java.util.Date;

/**
 * Created by asantha on 6/19/16.
 */
public class Webserviceclient {


    public static void main(String[] args){

        try {
            URL url = new URL("http://localhost:8989/services/Webservice?wsdl");
            QName qname = new QName("http://ws.spring.org", "WebserviceService");
            Service service = Service.create(url, qname);
            IWebservice webservice = service.getPort(IWebservice.class);
            JSONObject object = new JSONObject();
            object.put("userName", "asantha");
            object.put("latitude", 1.231311);
            object.put("longitude", 1.343353);
            object.put("numberOfVisits", 10);
            object.put("date", new Date());
            String[] users = new String[1];
            users[0] = object.toString();
            boolean status = webservice.addUser(users);
            System.out.println("Webservice response :" + status);
        }catch (Exception e){

            System.out.println(e.getLocalizedMessage());
        }
    }
}
