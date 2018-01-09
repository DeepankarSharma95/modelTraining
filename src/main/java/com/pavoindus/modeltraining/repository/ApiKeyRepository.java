package com.pavoindus.modeltraining.repository;

import com.pavoindus.modeltraining.model.ApiKey;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApiKeyRepository extends PagingAndSortingRepository<ApiKey, Long> {

    ApiKey findByApiKey(String apiKey);
    ApiKey findByApplicationName(String applicationName);
    ApiKey findByApiKeyAndApplicationName(String apiKey, String applicationName);
}
