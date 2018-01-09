package com.pavoindus.modeltraining.autoconfigue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "payroll-results.authentication", ignoreUnknownFields = false)
public class AuthenticationProperties extends PayrollServiceProperties {

    public AuthenticationProperties() {
        super();
    }

    private String tokenValidationUrl = "validateToken";

    public String getTokenValidationUrl() {
        return tokenValidationUrl;
    }

    public void setTokenValidationUrl(String tokenValidationUrl) {
        this.tokenValidationUrl = tokenValidationUrl;
    }
}
