package com.pavoindus.modeltraining;

import com.pavoindus.modeltraining.context.ApplicationContext;
import com.pavoindus.modeltraining.model.Receiver;
import com.pavoindus.modeltraining.service.Consumer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * Created 12/11/2017 21:15
 *
 * @author Deepankar Sharma
 */
@SpringBootApplication
public class ModelTrainingApplication extends SpringBootServletInitializer {

  public static final String data_processing_queue_name = "pr-processing-queue";
  public static final String data_processed_queue_name = "pr-processed-queue";
  public static final String exchangeName = "payroll-results";

  /*
  Rabbit MQ Consumer Begin
   */
  @Bean
  Queue queue1() {
    return new Queue(data_processed_queue_name);
  }

  @Bean
  Queue queue2() {
    return new Queue(data_processing_queue_name);
  }


  @Bean
  TopicExchange exchange() {
    return new TopicExchange(exchangeName);
  }

  @Bean
  Binding binding1(@Qualifier("queue1") Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(data_processed_queue_name);
  }

  @Bean
  Binding binding2(@Qualifier("queue2") Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(data_processing_queue_name);
  }

  @Bean
  MessageListenerAdapter listenerAdapter(Consumer receiver) {
    return new MessageListenerAdapter(receiver, "receiveMessage");
  }

  @Bean
  SimpleMessageListenerContainer container(ConnectionFactory factory,
                                           MessageListenerAdapter listenerAdapter) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(factory);
    container.setQueueNames(data_processed_queue_name);
    container.setMessageListener(listenerAdapter);
    return container;
  }
  /*
  Rabbit MQ Consumer End
   */

  @Override protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
    return builder.sources(ModelTrainingApplication.class);
  }

  public static void main(String[] args) {
    ApplicationContext.init();
    SpringApplication.run(ModelTrainingApplication.class, args);
  }
}
