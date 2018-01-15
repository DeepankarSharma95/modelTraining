package com.pavoindus.modeltraining.model;

import java.io.Serializable;

public class PredictiveConsumes implements Serializable {

    private ApplicationHeader headers;
    private Consumes data;

    public PredictiveConsumes(String apiKeyHeader, String apiKey, String applicationNameHeader, String applicationName, String modelName, String modelType, Long modelId, boolean exportFlag, Object[] trainingData, Object[] testData) {
        this.headers = new ApplicationHeader(apiKeyHeader, apiKey, applicationNameHeader, applicationName);
        this.data = new Consumes(modelName, modelType, exportFlag, trainingData, testData, modelId);
    }

    public ApplicationHeader getHeaders() {
        return headers;
    }

    public void setHeaders(ApplicationHeader headers) {
        this.headers = headers;
    }

    public Consumes getData() {
        return data;
    }

    public void setData(Consumes data) {
        this.data = data;
    }

    public class Consumes {
        private String modelName;
        private String modelType;
        private boolean exportFlag;
        private Object[] trainingData;
        private Object[] testData;
        private Long modelId;

        public Consumes(String modelName, String modelType, boolean exportFlag, Object[] trainingData, Object[] testData, Long modelId) {
            this.modelName = modelName;
            this.modelType = modelType;
            this.exportFlag = exportFlag;
            this.trainingData = trainingData;
            this.testData = testData;
            this.modelId = modelId;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public String getModelType() {
            return modelType;
        }

        public void setModelType(String modelType) {
            this.modelType = modelType;
        }

        public boolean isExportFlag() {
            return exportFlag;
        }

        public void setExportFlag(boolean exportFlag) {
            this.exportFlag = exportFlag;
        }

        public Object[] getTrainingData() {
            return trainingData;
        }

        public void setTrainingData(Object[] trainingData) {
            this.trainingData = trainingData;
        }

        public Object[] getTestData() {
            return testData;
        }

        public void setTestData(Object[] testData) {
            this.testData = testData;
        }

        public Long getModelId() {
            return modelId;
        }

        public void setModelId(Long modelId) {
            this.modelId = modelId;
        }
    }
}

