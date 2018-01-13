package com.pavoindus.modeltraining.model;

import java.io.Serializable;

public class PredictiveProduces implements Serializable{

    private ApplicationHeader headers;
    private Object data;

    public PredictiveProduces() {
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
