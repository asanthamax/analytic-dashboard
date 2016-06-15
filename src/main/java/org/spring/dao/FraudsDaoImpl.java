package org.spring.dao;

import org.spring.models.Frauds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Repository("fraudsDao")
public class FraudsDaoImpl implements FraudsDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static String COLLECTION = "Frauds";

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
