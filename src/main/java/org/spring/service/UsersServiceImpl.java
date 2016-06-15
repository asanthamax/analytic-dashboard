package org.spring.service;

import org.spring.dao.UsersDao;
import org.spring.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public void addUser(Users user) {

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
