package com.pavoindus.modeltraining.model;

import java.io.Serializable;

public class ModelTraining implements Serializable{

    private String modelName;
    private Long modelId;
    private Double[][] weight;
    private boolean export = true;

    public ModelTraining(String modelName, Long modelId, Double[][] weight) {
        this.modelName = modelName;
        this.modelId = modelId;
        this.weight = weight;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Double[][] getWeight() {
        return weight;
    }

    public void setWeight(Double[][] weight) {
        this.weight = weight;
    }

    public boolean isExport() {
        return export;
    }

    public void setExport(boolean export) {
        this.export = export;
    }
}
