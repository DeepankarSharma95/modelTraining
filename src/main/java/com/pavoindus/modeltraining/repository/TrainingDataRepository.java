package com.pavoindus.modeltraining.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pavoindus.modeltraining.model.TrainingData;
import com.pavoindus.modeltraining.model.TrainingDataInfo;

public interface TrainingDataRepository extends PagingAndSortingRepository<TrainingData, Long> {

  List<TrainingData> findByTrainingDataInfo(TrainingDataInfo trainingDataInfo);
}
