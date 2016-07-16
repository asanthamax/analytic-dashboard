package org.spring.dao;

import org.spring.models.Claims;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
public interface ClaimsDao {

    public void addClaim(Claims claim);

    public List<Claims> getClaims(Map<String,Object> map);

    public Claims getClaim(Map<String,Object> map);

    public void updateClaim(Map<String,Object> map);

    public void deleteClaim(Map<String,Object> map);
}
