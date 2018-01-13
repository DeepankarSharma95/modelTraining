package com.pavoindus.modeltraining.model;

public class ApplicationHeader {

    private String apiKeyHeader;
    private String apiKey;
    private String applicationNameHeader;
    private String applicationName;

    protected ApplicationHeader() {
    }

    public ApplicationHeader(String apiKeyHeader, String apiKey, String applicationNameHeader, String applicationName) {
        this.apiKeyHeader = apiKeyHeader;
        this.apiKey = apiKey;
        this.applicationNameHeader = applicationNameHeader;
        this.applicationName = applicationName;
    }

    public String getApiKeyHeader() {
        return apiKeyHeader;
    }

    public void setApiKeyHeader(String apiKeyHeader) {
        this.apiKeyHeader = apiKeyHeader;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApplicationNameHeader() {
        return applicationNameHeader;
    }

    public void setApplicationNameHeader(String applicationNameHeader) {
        this.applicationNameHeader = applicationNameHeader;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
