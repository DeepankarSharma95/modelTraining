package com.pavoindus.modeltraining.service;

import com.pavoindus.modeltraining.APIRequestFilter;
import com.pavoindus.modeltraining.ModelTrainingApplication;
import com.pavoindus.modeltraining.model.ApiKey;
import com.pavoindus.modeltraining.model.Model;
import com.pavoindus.modeltraining.model.ModelAnalysis;
import com.pavoindus.modeltraining.model.PredictiveProduces;
import com.pavoindus.modeltraining.repository.ApiKeyRepository;
import com.pavoindus.modeltraining.repository.ModelAnalysisRepository;
import com.pavoindus.modeltraining.repository.ModelRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

    private static final Log logger = LogFactory.getLog(Consumer.class);

    @Autowired
    private ModelTrainingService modelTrainingService;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelAnalysisRepository modelAnalysisRepository;

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    @RabbitListener(queues = ModelTrainingApplication.data_processed_queue_name)
    public void receiveMessage(String message) {
        logger.info(message);
        PredictiveProduces receivedModel = null;
        try {
            receivedModel = new ObjectMapper().readValue(message, PredictiveProduces.class);
        } catch (IOException e) {
            logger.error("Exception occurred while parsing queued response for PredictiveConsumes model" + e);
        }

        if(receivedModel != null && validateHeaders(receivedModel.getHeaders().getApiKeyHeader(),
                receivedModel.getHeaders().getApiKey(),
                receivedModel.getHeaders().getApplicationNameHeader(),
                receivedModel.getHeaders().getApplicationName())) {
            try {
                Model model = modelRepository.findOne(receivedModel.getData().getModelId());
                ModelAnalysis analysis = new ModelAnalysis(model, receivedModel.getData().getTruePositive(),
                        receivedModel.getData().getFalseNegative(), receivedModel.getData().getAccuracy(),
                        receivedModel.getData().getScore(), receivedModel.getData().getLocation());
                model.setFileLocation(receivedModel.getData().getLocation());
                modelRepository.save(model);
                modelAnalysisRepository.save(analysis);
                logger.info("Data consumed successfully from Predictive service");
            } catch (Exception e) {
                logger.error("Something went wrong..." + e);
            }
        } else {
            logger.error("Unable to convert/validate received message to model.");
        }
    }

    private boolean validateHeaders(String apiKeyHeader, String apiKey, String applicationNameHeader, String applicationName) {
        if((APIRequestFilter.API_KEY_HEADER.equalsIgnoreCase(apiKeyHeader)
                || APIRequestFilter.PAYROLL_RESULTS_API_KEY_HEADER.equalsIgnoreCase(apiKeyHeader))
                && APIRequestFilter.APPLICATION_NAME_HEADER.equalsIgnoreCase(applicationNameHeader)
                && apiKey != null && applicationName != null) {
            ApiKey key = apiKeyRepository.findByApiKeyAndApplicationName(apiKey, applicationName);
            return key != null;
        }
        return false;
    }
}
