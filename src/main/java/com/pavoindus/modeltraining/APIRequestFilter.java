package com.pavoindus.modeltraining;

import com.pavoindus.modeltraining.autoconfigue.AuthenticationProperties;
import com.pavoindus.modeltraining.context.ApplicationContext;
import com.pavoindus.modeltraining.model.ApiKey;
import com.pavoindus.modeltraining.repository.ApiKeyRepository;
import com.pavoindus.modeltraining.response.HttpServiceResponse;
import com.pavoindus.modeltraining.util.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class APIRequestFilter implements Filter {

    public static final String PAYROLL_RESULTS_API_KEY_HEADER = "X-Payroll-Results-API-Key";
    public static final String API_KEY_HEADER = "X-Payroll-Results-Model-Training-API-Key";
    public static final String APPLICATION_NAME_HEADER = "X-Payroll-Results-Application";
    public static final String SERVICE_NAME = "Model Training Service";

    private static final String AUTH_TOKEN_HEADER = "X-Payroll-Results-Auth-Token";
    private static final String AUTH_TOKEN = "authToken";

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    @Autowired
    private AuthenticationProperties authProperties;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (validateRequest(request)) {
            ApplicationContext.create();
            ApplicationContext.get().setApiKey(getApiKeyObject(request));
            HttpServletResponse response = ((HttpServletResponse) servletResponse);
            response.setHeader("Access-Control-Allow-Origin", "*");
            filterChain.doFilter(servletRequest, servletResponse);
            ApplicationContext.destroy();
            return;
        }
        HttpServletResponse response = ((HttpServletResponse) servletResponse);
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized request");
    }

    @Override
    public void destroy() {
    }

    private boolean validateRequest(HttpServletRequest request) throws IOException {
        String authToken = request.getHeader(AUTH_TOKEN_HEADER);
        ApiKey apiKeyObject = getApiKeyObject(request);
        if (apiKeyObject != null && authToken != null) {
            Map<String, String> params = new HashMap<>();
            params.put("authToken", authToken);
            Map<String, String> headers = new HashMap<>();
            headers.put(authProperties.getApiKeyHeader(), authProperties.getApiKey());
            headers.put(APPLICATION_NAME_HEADER, SERVICE_NAME);
            headers.put(HttpUtil.CONTENT_TYPE, HttpUtil.CONTENT_TYPE_VALUE);
            String response = HttpUtil.getInstance().call("http://" + authProperties.getUrl() + "/" + authProperties.getTokenValidationUrl(), new ObjectMapper().writeValueAsString(params), headers, HttpUtil.POST);
            if (response != null && !response.isEmpty()) {
                HttpServiceResponse serviceResponse = new ObjectMapper().readValue(response, HttpServiceResponse.class);
                if (serviceResponse != null && serviceResponse.getData() instanceof Map) {
                    Map data = (Map) serviceResponse.getData();
                    return data.get(AUTH_TOKEN).equals(authToken);
                }
            }
        }
        return false;
    }

    private ApiKey getApiKeyObject(HttpServletRequest request) {
        String apiKey;
        String serviceSpecificApiKey = request.getHeader(API_KEY_HEADER);
        if (serviceSpecificApiKey == null) {
            apiKey = request.getHeader(PAYROLL_RESULTS_API_KEY_HEADER);
        } else {
            apiKey = serviceSpecificApiKey;
        }
        String applicationName = request.getHeader(APPLICATION_NAME_HEADER);
        return apiKeyRepository.findByApiKeyAndApplicationName(apiKey, applicationName);
    }
}
