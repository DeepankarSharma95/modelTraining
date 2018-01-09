package com.pavoindus.modeltraining.repository;

import com.pavoindus.modeltraining.model.Model;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModelRepository extends PagingAndSortingRepository<Model, Long> {
}
