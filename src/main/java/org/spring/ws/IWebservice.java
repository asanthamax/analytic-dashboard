package org.spring.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by asantha on 6/16/16.
 */
@WebService(serviceName = "WebserviceService")
public interface IWebservice {

    @WebMethod(operationName = "addUser") boolean addUser(@WebParam(name = "users") String[] users);

    @WebMethod(operationName = "updateUser") boolean updateUser(@WebParam(name = "users") String[] users);

    @WebMethod(operationName = "addDevice") boolean addDevice(@WebParam(name = "devices") String[] devices);

    @WebMethod(operationName = "addFrauds") boolean addFrauds(@WebParam(name = "frauds") String[] frauds);

    @WebMethod(operationName = "updateFrauds") boolean updateFrauds(@WebParam(name = "frauds") String[] frauds);

    @WebMethod(operationName = "addRoles") boolean addRoles(@WebParam(name = "roles") String[] roles);

    @WebMethod(operationName = "updateRoles") boolean updateRoles(@WebParam(name = "roles") String[] roles);

    @WebMethod(operationName = "addUsers") boolean addUsers(@WebParam(name = "users") String[] users);

    @WebMethod(operationName = "updateUsers") boolean updateUsers(@WebParam(name = "users") String[] users);

    @WebMethod(operationName = "updateDevices") boolean updateDevice(@WebParam(name = "devices") String[] devices);
}
