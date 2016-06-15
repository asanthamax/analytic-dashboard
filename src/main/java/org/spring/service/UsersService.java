package org.spring.service;

import org.spring.models.Users;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
public interface UsersService {

    public void addUser(Users user);

    public List<Users> listUsers(Map<String,Object> map);

    public Users getUser(Map<String,Object> map);

    public void updateUser(Users user);

    public void deleteUser(Users user);
}
