package org.spring.dao;

import org.spring.models.Users;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
public interface UsersDao {

    public void addUser(Users user);

    public List<Users> listUsers(Map<String,Object> map);

    public Users getUser(Map<String,Object> map);

    public void updateUser(Users user);

    public void deleteUser(Users user);

}
