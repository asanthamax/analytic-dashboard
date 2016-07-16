package org.spring.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.dao.UsersDao;
import org.spring.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Configurable
@Service
public class UsersServiceImpl implements UsersService {

    private Log log = LogFactory.getLog(UsersServiceImpl.class);
    @Autowired
    private UsersDao usersDao;

    @Override
    public void addUser(Users user) {

        try{

            usersDao.addUser(user);

        }catch(Exception e){

            log.error("Error!!!"+e.getMessage());
        }
    }

    @Override
    public List<Users> listUsers(Map<String, Object> map) {
        return null;
    }

    @Override
    public Users getUser(Map<String, Object> map) {
        return null;
    }

    @Override
    public void updateUser(Users user) {

    }

    @Override
    public void deleteUser(Users user) {

    }
}
