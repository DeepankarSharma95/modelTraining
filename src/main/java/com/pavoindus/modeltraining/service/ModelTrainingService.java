package com.pavoindus.modeltraining.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pavoindus.modeltraining.model.Model;
import com.pavoindus.modeltraining.model.ModelConfig;
import com.pavoindus.modeltraining.model.TrainingData;
import com.pavoindus.modeltraining.model.TrainingDataInfo;

public interface ModelTrainingService {

    TrainingDataInfo uploadTrainingData(MultipartFile file, String name);
    ModelConfig createModel(Long trainingDataInfoId, String name, String type, Double[] coeff);
    ModelConfig getModel(Long id);
    List<TrainingDataInfo> getAllTrainingDataInfo();
    List<Model> getAllModels();
    List<TrainingData> getTrainingDataForInfo(Long id);
}
