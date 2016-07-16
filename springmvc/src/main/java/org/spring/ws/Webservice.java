package org.spring.ws;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.spring.models.Users;
import org.spring.service.*;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebService;
import java.util.*;

/**
 * Created by asantha on 6/15/16.
 */
@Service
@WebService(serviceName = "WebserviceService",endpointInterface = "org.spring.ws.IWebservice",portName = "WebservicePort",targetNamespace = "http://ws.spring.org")
public class Webservice implements IWebservice {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ClaimsService claimsService;

    @Autowired
    private DevicesService devicesService;

    @Autowired
    private FraudsService fraudsService;

    @Autowired
    private RolesService rolesService;

    /*public Webservice(){


    }*/

    @Override
    public boolean addUser(String[] users) throws WebserviceException{

        try {

            for (String user : users) {

                JSONObject userObject = new JSONObject(user);
                Map<String,Object> map = toMap(userObject);
                BeanWrapper wrapper = new BeanWrapperImpl(Users.class);
                wrapper.setPropertyValues(map);
                Users userDBObject = (Users) wrapper.getWrappedInstance();
                usersService.addUser(userDBObject);
            }
            return true;
        }catch(Exception ex){

            Throwable t = ex;
            throw new WebserviceException("JSON Parse Error occurred",t);
        }
    }

    @Override
    public boolean updateUser(String[] users) throws WebserviceException{

        return false;
    }

    @Override
    public boolean addDevice(String[] devices) throws WebserviceException{

        return false;
    }

    @Override
    public boolean updateDevice(String[] devices) throws WebserviceException{

        return false;
    }

    @Override
    public boolean addFrauds(String[] frauds) throws WebserviceException{

        return false;
    }

    @Override
    public boolean updateFrauds(String[] frauds) throws WebserviceException{

        return false;
    }

    @Override
    public boolean addRoles(String[] roles) throws WebserviceException{

        return false;
    }

    @Override
    public boolean updateRoles(String[] roles) throws WebserviceException{

        return false;
    }

    @Override
    public boolean addUsers(String[] users) throws WebserviceException{

        return false;
    }

    private static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    private static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }

}
