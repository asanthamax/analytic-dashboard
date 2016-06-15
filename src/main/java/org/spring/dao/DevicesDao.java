package org.spring.dao;

import org.spring.models.Devices;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
public interface DevicesDao {

    public void addDevice(Devices device);

    public List<Devices> getDevices(Map<String,Object> map);

    public Devices getDevice(Map<String,Object> map);

    public void updateDevice(Devices device);

    public void deleteDevice(Devices device);
}
