package com.pavoindus.modeltraining.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pavoindus.modeltraining.model.TrainingDataInfo;

/**
 * Created 1/9/2018 00:10
 *
 * @author Deepankar Sharma
 */
public interface TrainingDataInfoRepository extends PagingAndSortingRepository<TrainingDataInfo, Long> {

}
