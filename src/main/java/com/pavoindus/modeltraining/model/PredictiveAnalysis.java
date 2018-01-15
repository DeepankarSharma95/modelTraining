package com.pavoindus.modeltraining.model;

public class PredictiveAnalysis {

    private String location;
    private String[][] data;

    public PredictiveAnalysis(String location, String[][] data) {
        this.location = location;
        this.data = data;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }
}
