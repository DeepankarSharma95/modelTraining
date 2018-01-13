package com.pavoindus.modeltraining.service;

import com.pavoindus.modeltraining.ModelTrainingApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Log logger = LogFactory.getLog(Consumer.class);

    @Autowired
    private ModelTrainingService modelTrainingService;

    @RabbitListener(queues = ModelTrainingApplication.data_processed_queue_name)
    public void receiveMessage(String message) {
        logger.info(message);
    }
}
