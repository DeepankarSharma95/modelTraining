package com.pavoindus.modeltraining.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pavoindus.modeltraining.model.ModelAnalysis;

/**
 * Created 1/9/2018 00:12
 *
 * @author Deepankar Sharma
 */
public interface ModelAnalysisRepository extends PagingAndSortingRepository<ModelAnalysis, Long> {

}
