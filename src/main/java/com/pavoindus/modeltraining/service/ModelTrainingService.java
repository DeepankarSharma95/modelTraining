package com.pavoindus.modeltraining.service;

import com.pavoindus.modeltraining.model.Model;
import com.pavoindus.modeltraining.model.ModelConfig;
import com.pavoindus.modeltraining.model.TrainingData;
import com.pavoindus.modeltraining.model.TrainingDataInfo;
import com.pavoindus.modeltraining.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ModelTrainingService {

    TrainingDataInfo uploadTrainingData(MultipartFile file, String name);
    ModelConfig createModel(Long trainingDataInfoId, String name, String type, Double[] coeff);
    ModelConfig getModel(Long id);
    List<TrainingDataInfo> getAllTrainingDataInfo();
    List<Model> getAllModels();
    List<TrainingData> getTrainingDataForInfo(Long id);
    void queueModelForTraining(ModelConfig config);
    APIResponse getModelAnalysisFromPredictiveService(MultipartFile file, Long modelId);
}
