package org.spring.dao;

import org.spring.models.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Repository("rolesDao")
public class RolesDaoImpl implements RolesDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static String COLLECTION = "Roles";

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
