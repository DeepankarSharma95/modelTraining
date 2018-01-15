package com.pavoindus.modeltraining.model;

import java.io.Serializable;

public class PredictiveProduces implements Serializable{

    private ApplicationHeader headers;
    private Produces data;

    public PredictiveProduces() {
    }

    public ApplicationHeader getHeaders() {
        return headers;
    }

    public void setHeaders(ApplicationHeader headers) {
        this.headers = headers;
    }

    public Produces getData() {
        return data;
    }

    public void setData(Produces data) {
        this.data = data;
    }

    public class Produces {

        private String truePositive;
        private String falseNegative;
        private String accuracy;
        private String score;
        private String location;
        private Long modelId;

        public Produces() {
        }

        public String getTruePositive() {
            return truePositive;
        }

        public void setTruePositive(String truePositive) {
            this.truePositive = truePositive;
        }

        public String getFalseNegative() {
            return falseNegative;
        }

        public void setFalseNegative(String falseNegative) {
            this.falseNegative = falseNegative;
        }

        public String getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(String accuracy) {
            this.accuracy = accuracy;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Long getModelId() {
            return modelId;
        }

        public void setModelId(Long modelId) {
            this.modelId = modelId;
        }
    }
}


