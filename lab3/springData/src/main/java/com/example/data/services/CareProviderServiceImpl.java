package com.example.data.services;


import com.example.data.domain.CareProvider;
import com.example.data.repositories.CareProviderRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CareProviderServiceImpl implements CareProviderService {

    private final CareProviderRepository careProviderRepository;

    public CareProviderServiceImpl(CareProviderRepository careProviderRepository) {
        this.careProviderRepository = careProviderRepository;
    }

    @Override
    public CareProvider save(CareProvider careProvider) {

        if(!careProvider.equals(null))
            return careProviderRepository.save(careProvider);
        return null;
    }

    @Override
    public List<CareProvider> findAll() {
        return (List<CareProvider>) careProviderRepository.findAll();
    }

    @Override
    public List<CareProvider> finProvidersByName(String name) {
        return (List<CareProvider>) careProviderRepository.findCareProviderByName(name);
    }

}
