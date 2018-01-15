package com.pavoindus.modeltraining.autoconfigue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "payroll-results.predictive", ignoreUnknownFields = false)
public class PredictiveProperties extends PayrollServiceProperties {
    public PredictiveProperties() {
        super();
    }

    private String predictUrl = "predict";

    public String getPredictUrl() {
        return predictUrl;
    }

    public void setPredictUrl(String predictUrl) {
        this.predictUrl = predictUrl;
    }
}
