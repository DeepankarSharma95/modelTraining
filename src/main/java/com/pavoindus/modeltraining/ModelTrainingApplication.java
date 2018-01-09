package com.pavoindus.modeltraining;

import com.pavoindus.modeltraining.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created 12/11/2017 21:15
 *
 * @author Deepankar Sharma
 */
@SpringBootApplication
public class ModelTrainingApplication extends SpringBootServletInitializer {

  @Override protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
    return builder.sources(ModelTrainingApplication.class);
  }

  public static void main(String[] args) {
    ApplicationContext.init();
    SpringApplication.run(ModelTrainingApplication.class, args);
  }
}
