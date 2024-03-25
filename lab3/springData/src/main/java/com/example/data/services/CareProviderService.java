package com.example.data.services;

import java.util.List;

import com.example.data.domain.CareProvider;

public interface CareProviderService {
    CareProvider save(CareProvider stud);
    List<CareProvider> findAll();
    List<CareProvider> finProvidersByName(String name);
}