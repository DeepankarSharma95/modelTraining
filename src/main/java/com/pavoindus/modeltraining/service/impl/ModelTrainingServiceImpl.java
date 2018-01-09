package com.pavoindus.modeltraining.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pavoindus.modeltraining.model.Model;
import com.pavoindus.modeltraining.model.ModelConfig;
import com.pavoindus.modeltraining.model.TrainingData;
import com.pavoindus.modeltraining.model.TrainingDataInfo;
import com.pavoindus.modeltraining.repository.ModelConfigRepository;
import com.pavoindus.modeltraining.repository.ModelRepository;
import com.pavoindus.modeltraining.repository.TrainingDataInfoRepository;
import com.pavoindus.modeltraining.repository.TrainingDataRepository;
import com.pavoindus.modeltraining.response.Failure;
import com.pavoindus.modeltraining.service.ModelTrainingService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Component
@Service
public class ModelTrainingServiceImpl implements ModelTrainingService {

    private static final Log logger = LogFactory.getLog(ModelTrainingServiceImpl.class);
    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelConfigRepository modelConfigRepository;

    @Autowired
    private TrainingDataRepository trainingDataRepository;
    @Autowired
    private TrainingDataInfoRepository trainingDataInfoRepository;

    @Override
    public TrainingDataInfo uploadTrainingData(MultipartFile file, String name) {
        TrainingDataInfo trainingDataInfo = new TrainingDataInfo(name, TrainingDataInfo.Status.PROCESSING);
        trainingDataInfoRepository.save(trainingDataInfo);
        processFile(file, trainingDataInfo);
        return trainingDataInfo;
    }

    @Override
    public ModelConfig createModel(Long trainingDataInfoId, String name, String type, Double[] coeff) {
        TrainingDataInfo trainingDataInfo = trainingDataInfoRepository.findOne(trainingDataInfoId);
        Model model = new Model(trainingDataInfo, name, Model.Type.valueOf(type));
        modelRepository.save(model);
        ModelConfig config = new ModelConfig(model, coeff);
        modelConfigRepository.save(config);
        return config;
    }

    @Override
    public ModelConfig getModel(Long id) {
        return modelConfigRepository.findOne(id);
    }

    @Override
    public List<TrainingDataInfo> getAllTrainingDataInfo() {
        return (List<TrainingDataInfo>) trainingDataInfoRepository.findAll();
    }

    @Override public List<Model> getAllModels() {
        return (List<Model>) modelRepository.findAll();
    }

    @Override public List<TrainingData> getTrainingDataForInfo(Long id) {
        TrainingDataInfo info = trainingDataInfoRepository.findOne(id);
        return info != null ? trainingDataRepository.findByTrainingDataInfo(info) : null;
    }

    private void processFile(MultipartFile file, TrainingDataInfo info) {
        List<TrainingData> records = new ArrayList<>();
        List<String> fileLines;
        StringBuilder sb = new StringBuilder();
        int rowsProcessed = 0;
        boolean hasErrors = false;
        try {
            String content = new String(file.getBytes());
            String splitter = content.contains("\\r\\n") ? "\\r\\n" : "\\n";
            String[] rows = content.split(splitter);
            int index = 1;
            for(String row : rows) {
                String[] columns = row.split(",");
                logger.info("Processing row: " + index++);
                if(columns.length != 31) {
                    logger.error("Row doesn't contain 31 cols. Rejecting: " + row);
                    sb.append("Row doesn't contain 31 cols. Rejecting: ");
                    sb.append(row);
                    sb.append(", ");
                    hasErrors = true;
                    break;
                }
                Double[] data = new Double[29];
                for(int i = 0; i < 29; i++) {
                    data[i] = Double.parseDouble(columns[i+2]);
                }
                TrainingData
                    trainingData = new TrainingData(info, Long.parseLong(columns[0]), Long.parseLong(columns[1]), data);
                records.add(trainingData);
            }
            rowsProcessed = rows.length;
        } catch (IOException e) {
            logger.error("Error reading file", e);
            sb.append("Error reading file");
            hasErrors = true;
        }
        if(!hasErrors) {
            for (TrainingData data : records) {
                trainingDataRepository.save(data);
            }
            info.setStatus(TrainingDataInfo.Status.ACTIVE);
            info.setInfo(rowsProcessed + " rows processed successfully");
        } else {
            info.setStatus(TrainingDataInfo.Status.ERROR);
            info.setInfo(sb.toString().substring(0, 499));
        }
        trainingDataInfoRepository.save(info);
    }
}
