package com.pavoindus.modeltraining.model;

import java.io.Serializable;

public class PredictiveConsumes implements Serializable {

    private ApplicationHeader headers;
    private Object data;

    public PredictiveConsumes(String apiKeyHeader, String apiKey, String applicationNameHeader, String applicationName, Object data) {
        this.headers = new ApplicationHeader(apiKeyHeader, apiKey, applicationNameHeader, applicationName);
        this.data = data;
    }

    public ApplicationHeader getHeaders() {
        return headers;
    }

    public void setHeaders(ApplicationHeader headers) {
        this.headers = headers;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}