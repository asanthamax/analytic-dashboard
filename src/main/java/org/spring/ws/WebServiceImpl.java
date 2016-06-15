package org.spring.ws;

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by asantha on 6/15/16.
 */
@Path("/xml/webservice")
public class WebServiceImpl {

    private Webservice cal;

    public WebServiceImpl(){

        cal = new Webservice();
    }

    @POST
    @Path("addUser/{incomingUserData}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUserData(@PathParam("incomingUserData") JSONObject userObject){

        String result = "";
        if(cal.addUser(userObject)){

            result = "User data Added Successfully";
        }
        else{
            result = "cannot add data error occured";
        }
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("updateUser/{incomingUserData}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateUser(@PathParam("incomingUserData") JSONObject userObject){

        String result = "";
        if(cal.updateUser(userObject)){

            result = "User updated Successfully";
        }
        else{

            result = "cannot update user error occured";
        }
        return Response.status(200).entity(result).build();
    }
}
