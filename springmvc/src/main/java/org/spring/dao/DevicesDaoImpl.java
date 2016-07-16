package org.spring.dao;

import org.spring.models.Devices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Repository("devicesDao")
public class DevicesDaoImpl implements DevicesDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static String COLLECTION = "Devices";

    @Override
    public void addDevice(Devices device) {

    }

    @Override
    public List<Devices> getDevices(Map<String, Object> map) {
        return null;
    }

    @Override
    public Devices getDevice(Map<String, Object> map) {
        return null;
    }

    @Override
    public void updateDevice(Devices device) {

    }

    @Override
    public void deleteDevice(Devices device) {

    }
}
