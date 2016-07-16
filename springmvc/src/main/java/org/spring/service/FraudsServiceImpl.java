package org.spring.service;

import org.spring.dao.FraudsDao;
import org.spring.models.Frauds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Service("fraudsService")
public class FraudsServiceImpl implements FraudsService{

    @Autowired
    private FraudsDao fraudsDao;

    @Override
    public void addFraud(Frauds fraud) {

    }

    @Override
    public List<Frauds> getFrauds(Map<String, Object> map) {
        return null;
    }

    @Override
    public Frauds getFraud(Map<String, Object> map) {
        return null;
    }

    @Override
    public void updateFraud(Frauds fraud) {

    }

    @Override
    public void deleteFraud(Frauds fraud) {

    }
}
