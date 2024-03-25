package com.example.data.bootstrap;

import com.example.data.domain.Address;
import com.example.data.domain.Card;
import com.example.data.domain.CareProvider;
import com.example.data.domain.MedicalEncounter;
import com.example.data.domain.Patient;
import com.example.data.domain.Patient;
import com.example.data.domain.CareProvider;
import com.example.data.repositories.PatientRepository;
import com.example.data.services.CareProviderService;
import com.example.data.services.PatientService;
import com.example.data.services.PatientService;
import com.example.data.services.PatientServiceImpl;
import com.example.data.services.CareProviderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final CareProviderService careProviderService;
    private final PatientService patientService;

    public DataLoader(CareProviderService CareProviderService, @Qualifier("PatientServiceEm") PatientService PatientService, PatientRepository PatientRepository) {
        this.careProviderService = CareProviderService;
        this.patientService = PatientService;
    }

    @Override
    public void run(String... args) throws Exception {
        MedicalEncounter medicalEncounter = new MedicalEncounter(1L, LocalDate.now());
        
        CareProvider s1= new CareProvider(123L, "John", "Smeker");
        s1.addEnounter(medicalEncounter);

        Patient p1 = new Patient("Samsar", 69L);

        p1.addMedicalEncounter(medicalEncounter);

        patientService.save(p1);

        List<Patient> patients = patientService.findFacultiesByName("Samsar");
        patients.forEach(System.out::println);
    }
}
