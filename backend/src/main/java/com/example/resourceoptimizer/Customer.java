package com.example.resourceoptimizer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private double demand;
    private double timeSensitivity;
    private double costEfficiency;

    public double getDemand() {
        return demand;
    }

    public void setDemand(double demand) {
        this.demand = demand;
    }

    public double getTimeSensitivity() {
        return timeSensitivity;
    }

    public void setTimeSensitivity(double timeSensitivity) {
        this.timeSensitivity = timeSensitivity;
    }

    public double getCostEfficiency() {
        return costEfficiency;
    }

    public void setCostEfficiency(double costEfficiency) {
        this.costEfficiency = costEfficiency;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
