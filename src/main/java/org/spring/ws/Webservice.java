package org.spring.ws;

import org.json.JSONObject;
import org.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by asantha on 6/15/16.
 */
@XmlRootElement(name = "service-data")
public class Webservice {

    private UsersService usersService = new UsersServiceImpl();
    private ClaimsService claimsService = new ClaimsServiceImpl();
    private DevicesService devicesService = new DevicesServiceImpl();
    private FraudsService fraudsService = new FraudsServiceImpl();
    private RolesService rolesService = new RolesServiceImpl();

    @XmlAttribute(name = "service-adduser")
    public boolean addUser(JSONObject users){

        return false;
    }

    @XmlAttribute(name = "service-updateuser")
    public boolean updateUser(JSONObject users){

        return false;
    }

    @XmlAttribute(name = "service-adddevice")
    public boolean addDevice(JSONObject devices){

        return false;
    }

    @XmlAttribute(name = "service-updatedevice")
    public boolean updateDevice(JSONObject devices){

        return false;
    }

    @XmlAttribute(name = "service-addfrauds")
    public boolean addFrauds(JSONObject frauds){

        return false;
    }

    @XmlAttribute(name = "service-updatefrauds")
    public boolean updateFrauds(JSONObject frauds){

        return false;
    }

    @XmlAttribute(name = "service-addroles")
    public boolean addRoles(JSONObject roles){

        return false;
    }

    @XmlAttribute(name = "service-updateroles")
    public boolean updateRoles(JSONObject roles){

        return false;
    }

    @XmlAttribute(name = "service-addusers")
    public boolean addUsers(JSONObject users){

        return false;
    }

    @XmlAttribute(name = "service-updateusers")
    public boolean updateUsers(JSONObject users){

        return false;
    }
}
