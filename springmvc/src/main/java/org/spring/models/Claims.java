package org.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by asantha on 6/15/16.
 */
@Document
public class Claims {

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getClaimDialect() {
        return claimDialect;
    }

    public void setClaimDialect(String claimDialect) {
        this.claimDialect = claimDialect;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public int getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(int usageCount) {
        this.usageCount = usageCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    private String Id;

    private String claim;

    private int usageCount;

    private Date date;

    private String claimDialect;

}
