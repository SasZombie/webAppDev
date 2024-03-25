package com.example.data.services;

import java.util.List;

import com.example.data.domain.Patient;

public interface PatientService {
    Patient save(Patient stud);
    List<Patient> findAll();
    List<Patient> findFacultiesByName(String name);
}