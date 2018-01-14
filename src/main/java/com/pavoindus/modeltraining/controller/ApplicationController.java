package com.pavoindus.modeltraining.controller;

import com.pavoindus.modeltraining.autoconfigue.AuthenticationProperties;
import com.pavoindus.modeltraining.autoconfigue.PredictiveProperties;
import com.pavoindus.modeltraining.form.ModelForm;
import com.pavoindus.modeltraining.form.TrainingDataForm;
import com.pavoindus.modeltraining.model.Model;
import com.pavoindus.modeltraining.model.ModelConfig;
import com.pavoindus.modeltraining.model.TrainingData;
import com.pavoindus.modeltraining.model.TrainingDataInfo;
import com.pavoindus.modeltraining.response.APIResponse;
import com.pavoindus.modeltraining.response.Failure;
import com.pavoindus.modeltraining.response.Success;
import com.pavoindus.modeltraining.service.ModelTrainingService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ApplicationController {

    private static final Log logger = LogFactory.getLog(ApplicationController.class);
    @Autowired
    private ModelTrainingService modelTrainingService;

    @PostMapping("/train/upload")
    public @ResponseBody
    APIResponse processTrainingDataUpload(@RequestBody TrainingDataForm trainingDataForm) {
        MultipartFile file = trainingDataForm.getFile();
        if (!file.getOriginalFilename().endsWith(".csv") && !file.getOriginalFilename()
                .endsWith(".txt")) {
            return new Failure("Unsupported file format. Expected .txt or .csv");
        }
        TrainingDataInfo trainingDataInfo = modelTrainingService.uploadTrainingData(trainingDataForm.getFile(), trainingDataForm.getName());
        if(trainingDataInfo == null) {
            return new Failure("Incorrect data in file. Check logs for more info");
        }
        return new Success(trainingDataInfo);
    }

    @GetMapping("/model")
    public @ResponseBody APIResponse getAllModels() {
        List<Model> models = modelTrainingService.getAllModels();
        if(models == null || models.isEmpty()) {
            return new Success();
        }
        return new Success(models);
    }

    @GetMapping("/model/{id}")
    public @ResponseBody APIResponse getModelConfig(@PathVariable("id") Long id) {
        ModelConfig config = modelTrainingService.getModel(id);
        if(config == null) {
            return new Failure("No model exists with ID: " + id);
        }
        return new Success(config);
    }

    @PostMapping("/model/{id}/train")
    public @ResponseBody APIResponse trainModel(@PathVariable("id") Long id) {
        ModelConfig config = modelTrainingService.getModel(id);
        if(config == null) {
            return new Failure("No model exists with ID: " + id);
        }
        modelTrainingService.queueModelForTraining(config);
        return new Success();
    }
    @GetMapping("/train")
    public @ResponseBody APIResponse getAllTrainingDataInfo() {
        return new Success(modelTrainingService.getAllTrainingDataInfo());
    }

    @GetMapping("/train/{id}")
    public @ResponseBody APIResponse getTrainingDataForInfoId(@PathVariable("id") Long id) {
        List<TrainingData> data = modelTrainingService.getTrainingDataForInfo(id);
        if(data == null || data.isEmpty()) {
            return new Failure("No Training Data exists for Info ID: "+ id);
        }
        return new Success(data);
    }

    @PostMapping("/model/create")
    public @ResponseBody APIResponse createNewModelAndConfig(@RequestBody ModelForm form) {
        ModelConfig config = modelTrainingService.createModel(form.getTrainingDataInfoId(), form.getName(), form.getType(), form.getWtArray());
        if(config == null) {
            return new Failure("Something went wrong while creating model");
        }
        return new Success(config);
    }

}
