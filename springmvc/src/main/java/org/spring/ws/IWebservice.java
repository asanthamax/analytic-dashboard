package org.spring.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by asantha on 6/16/16.
 */
@WebService(name = "WebservicePort")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT,use= SOAPBinding.Use.LITERAL)
public interface IWebservice {

    @WebMethod(operationName = "addUser") boolean addUser(@WebParam(name = "users") String[] users) throws WebserviceException;

    @WebMethod(operationName = "updateUser") boolean updateUser(@WebParam(name = "users") String[] users) throws WebserviceException;

    @WebMethod(operationName = "addDevice") boolean addDevice(@WebParam(name = "devices") String[] devices) throws WebserviceException;

    @WebMethod(operationName = "addFrauds") boolean addFrauds(@WebParam(name = "frauds") String[] frauds) throws WebserviceException;

    @WebMethod(operationName = "updateFrauds") boolean updateFrauds(@WebParam(name = "frauds") String[] frauds) throws WebserviceException;

    @WebMethod(operationName = "addRoles") boolean addRoles(@WebParam(name = "roles") String[] roles) throws WebserviceException;

    @WebMethod(operationName = "updateRoles") boolean updateRoles(@WebParam(name = "roles") String[] roles) throws WebserviceException;

    @WebMethod(operationName = "addUsers") boolean addUsers(@WebParam(name = "users") String[] users) throws WebserviceException;

    @WebMethod(operationName = "updateDevices") boolean updateDevice(@WebParam(name = "devices") String[] devices) throws WebserviceException;
}
