package com.pavoindus.modeltraining.model;

import java.io.Serializable;

public class Receiver implements Serializable {

    private ApplicationHeader headers;
    private Object data;

    public void receiveMessage(String jsonString) {
        // do something here
    }
}
