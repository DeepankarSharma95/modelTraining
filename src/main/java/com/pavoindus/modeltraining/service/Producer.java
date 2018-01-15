package com.pavoindus.modeltraining.service;

import com.pavoindus.modeltraining.ModelTrainingApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private static final Log logger = LogFactory.getLog(Producer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void queueData(String data) {
        logger.info("Queuing Data: \n" + data);
        rabbitTemplate.convertAndSend(ModelTrainingApplication.data_processing_queue_name, data);
    }
}
