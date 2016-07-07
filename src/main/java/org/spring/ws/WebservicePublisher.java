
package org.spring.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.xml.ws.Endpoint;

/**
 * Created by asantha on 6/19/16.
 */

@Component
public class WebservicePublisher implements ServletContextListener{

    @Autowired
    private Webservice webservice;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        Endpoint.publish("http://localhost:8989/services/Webservice",new Webservice());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

