package org.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by asantha on 6/15/16.
 */
@Document
public class Frauds {

    @Id
    private String Id;

    private String userName;

    private double latitude;

    private double longitude;

    private int detectedFraudsCount;

    private Date date;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude){this.longitude = longitude;}

    public double getLongitude(){return this.longitude;}

    public int getDetectedFraudsCount() {
        return detectedFraudsCount;
    }

    public void setDetectedFraudsCount(int detectedFraudsCount) {
        this.detectedFraudsCount = detectedFraudsCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
