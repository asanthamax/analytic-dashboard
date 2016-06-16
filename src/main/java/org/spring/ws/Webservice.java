package org.spring.ws;

import org.json.JSONObject;
import org.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by asantha on 6/15/16.
 */

@WebService(endpointInterface = "org.spring.ws.IWebservice")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use= SOAPBinding.Use.LITERAL)
public class Webservice implements IWebservice{

    @Autowired
    private UsersService usersService ;

    @Autowired
    private ClaimsService claimsService;

    @Autowired
    private DevicesService devicesService;

    @Autowired
    private FraudsService fraudsService;

    @Autowired
    private RolesService rolesService;

    public Webservice(){

    }

    @Override
    public boolean addUser(String[] users){

        return false;
    }

    @Override
    public boolean updateUser(String[] users){

        return false;
    }

    @Override
    public boolean addDevice(String[] devices){

        return false;
    }

    @Override
    public boolean updateDevice(String[] devices){

        return false;
    }

    @Override
    public boolean addFrauds(String[] frauds){

        return false;
    }

    @Override
    public boolean updateFrauds(String[] frauds){

        return false;
    }

    @Override
    public boolean addRoles(String[] roles){

        return false;
    }

    @Override
    public boolean updateRoles(String[] roles){

        return false;
    }

    @Override
    public boolean addUsers(String[] users){

        return false;
    }

    @Override
    public boolean updateUsers(String[] users){

        return false;
    }
}
