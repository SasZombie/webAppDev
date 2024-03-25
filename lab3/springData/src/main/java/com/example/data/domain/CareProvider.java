package com.example.data.domain;

import java.util.ArrayList;

public class CareProvider {
    private long ID;
    private String name;
    private String speciallity;
    private ArrayList<MedicalEncounter> encounters = new ArrayList<>();

    public CareProvider(long iD, String name, String speciallity) {
        ID = iD;
        this.name = name;
        this.speciallity = speciallity;
    }

    public void addEnounter(MedicalEncounter me){
        this.encounters.add(me);
    }
    
    public ArrayList<MedicalEncounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(ArrayList<MedicalEncounter> encounters) {
        this.encounters = encounters;
    }


    public long getID() {
        return ID;
    }
    public void setID(long iD) {
        ID = iD;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpeciallity() {
        return speciallity;
    }
    public void setSpeciallity(String speciallity) {
        this.speciallity = speciallity;
    }

    
}
