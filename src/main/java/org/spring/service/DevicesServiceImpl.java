package org.spring.service;

import org.spring.dao.DevicesDao;
import org.spring.models.Devices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Service("devicesService")
public class DevicesServiceImpl implements DevicesService{

    @Autowired
    private DevicesDao devicesDao;

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
