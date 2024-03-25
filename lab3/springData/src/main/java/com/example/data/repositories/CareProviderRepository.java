package com.example.data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.data.domain.CareProvider;

import java.util.List;

public interface CareProviderRepository extends CrudRepository<CareProvider,Long> {
    List<CareProvider> findCareProviderByName(String name);
}
