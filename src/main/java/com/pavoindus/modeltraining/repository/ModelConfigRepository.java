package com.pavoindus.modeltraining.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pavoindus.modeltraining.model.ModelConfig;

public interface ModelConfigRepository extends PagingAndSortingRepository<ModelConfig, Long> {
}
