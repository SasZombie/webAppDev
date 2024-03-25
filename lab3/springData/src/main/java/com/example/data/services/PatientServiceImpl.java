package com.example.data.services;


import com.example.data.domain.Patient;
import com.example.data.repositories.PatientRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(Patient patient) {
        if(!patient.equals(null))
            return patientRepository.save(patient);
        return null;
    }

    @Override
    public List<Patient> findAll() {
        
        return (List<Patient>) patientRepository.findAll();
    }

    @Override
    public List<Patient> findFacultiesByName(String name) {
        return (List<Patient>) patientRepository.findPatientsByName(name);
    }
}
