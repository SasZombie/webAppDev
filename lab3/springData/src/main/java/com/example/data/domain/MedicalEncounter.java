package com.example.data.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedicalEncounter {
    private long ID;
    private LocalDate date;
    private ArrayList<HealthService> services = new ArrayList<>();
    
    public MedicalEncounter(long iD, LocalDate date) {
        ID = iD;
        this.date = date;
    }

    public void AddServicies(HealthService hs){
        this.services.add(hs);
    }
    public long getID() {
        return ID;
    }
    public void setID(long iD) {
        ID = iD;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public ArrayList<HealthService> getServices() {
        return services;
    }
    public void setServices(ArrayList<HealthService> services) {
        this.services = services;
    }
    

}
