package com.harshith.marketintelligence.dto;

public class MetalsResponse {

    private String status;
    private MetalsData metals;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MetalsData getMetals() {
        return metals;
    }

    public void setMetals(MetalsData metals) {
        this.metals = metals;
    }
}