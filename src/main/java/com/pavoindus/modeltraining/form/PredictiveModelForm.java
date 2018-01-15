package com.pavoindus.modeltraining.form;

import org.springframework.web.multipart.MultipartFile;

public class PredictiveModelForm {

    private MultipartFile file;
    private Long modelId;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }
}
