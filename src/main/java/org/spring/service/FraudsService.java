package org.spring.service;

import org.spring.models.Frauds;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
public interface FraudsService {

    public void addFraud(Frauds fraud);

    public List<Frauds> getFrauds(Map<String,Object> map);

    public Frauds getFraud(Map<String,Object> map);

    public void updateFraud(Frauds fraud);

    public void deleteFraud(Frauds fraud);
}
