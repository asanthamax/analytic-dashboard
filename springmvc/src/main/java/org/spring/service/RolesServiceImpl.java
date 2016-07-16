package org.spring.service;

import org.spring.dao.RolesDao;
import org.spring.models.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Service("rolesService")
public class RolesServiceImpl implements RolesService{

    @Autowired
    private RolesDao rolesDao;

    @Override
    public void addRole(Roles role) {

    }

    @Override
    public List<Roles> getRoles(Map<String, Object> map) {
        return null;
    }

    @Override
    public Roles getRole(Map<String, Object> map) {
        return null;
    }

    @Override
    public void updateRole(Roles role) {

    }

    @Override
    public void deleteRole(Roles role) {

    }
}
