package org.spring.dao;

import org.spring.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static String COLLECTION = "Users";

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
