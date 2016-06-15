package org.spring.service;

import org.spring.models.Roles;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
public interface RolesService {

    public void addRole(Roles role);

    public List<Roles> getRoles(Map<String,Object> map);

    public Roles getRole(Map<String,Object> map);

    public void updateRole(Roles role);

    public void deleteRole(Roles role);
}
