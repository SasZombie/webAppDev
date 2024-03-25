package com.example.data.domain;

import java.util.ArrayList;

public class Patient {
    private String name;
    private long ID;
    private ArrayList<MedicalEncounter> medicalEncounters = new ArrayList<>();
    
    public Patient(String name, long iD) {
        this.name = name;
        ID = iD;
    }

    public void addMedicalEncounter(MedicalEncounter me){
        this.medicalEncounters.add(me);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getID() {
        return ID;
    }
    public void setID(long iD) {
        ID = iD;
    }

    public ArrayList<MedicalEncounter> getMedicalEncounters() {
        return medicalEncounters;
    }

    public void setMedicalEncounters(ArrayList<MedicalEncounter> me) {
        this.medicalEncounters = me;
    }

    
}
