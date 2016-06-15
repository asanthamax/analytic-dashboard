package org.spring.service;

import org.spring.dao.ClaimsDao;
import org.spring.models.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Service("claimsService")
public class ClaimsServiceImpl implements ClaimsService{

    @Autowired
    private ClaimsDao claimsDao;

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
