package org.spring.dao;

import org.spring.models.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Repository("claimsDao")
public class ClaimsDaoImpl implements ClaimsDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static String COLLECTION = "Claims";

    @Override
    public void addClaim(Claims claim) {

    }

    @Override
    public List<Claims> getClaims(Map<String, Object> map) {
        return null;
    }

    @Override
    public Claims getClaim(Map<String, Object> map) {
        return null;
    }

    @Override
    public void updateClaim(Map<String, Object> map) {

    }

    @Override
    public void deleteClaim(Map<String, Object> map) {

    }
}
