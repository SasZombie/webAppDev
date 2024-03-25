package com.example.data.domain;

import java.util.ArrayList;

public class HealtIssue {
    private long ID;
    private String type; // Should be enum :3
    private ArrayList<HealthService> services = new ArrayList<>();
   
    public HealtIssue(long iD, String type) {
        ID = iD;
        this.type = type;
    }

    public void addService(HealthService hs){
        this.services.add(hs);
    }

    public long getID() {
        return ID;
    }
    public void setID(long iD) {
        ID = iD;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public ArrayList<HealthService> getServices() {
        return services;
    }
    public void setServices(ArrayList<HealthService> services) {
        this.services = services;
    }

    
}
