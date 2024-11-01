package com.example.resourceoptimizer;

import java.util.Map;

public class AllocationResult {

    private Map<String, Double> allocatedResources; // Example map of customer ID to allocated resources
    private double totalCost;
    private double resourcesUsed;
    private double totalResources;
    private double customerSatisfactionScore;
    private int roundNumber;

    public AllocationResult() {
    }

    // Constructor
    public AllocationResult(double totalCost, double resourcesUsed, double totalResources, double customerSatisfactionScore, int roundNumber) {
        this.totalCost = totalCost;
        this.resourcesUsed = resourcesUsed;
        this.totalResources = totalResources;
        this.customerSatisfactionScore = customerSatisfactionScore;
        this.roundNumber = roundNumber;
    }

    // Getters
    public double getTotalCost() {
        return totalCost;
    }

    public double getResourcesUsed() {
        return resourcesUsed;
    }

    public double getTotalResources() {
        return totalResources;
    }

    public double getCustomerSatisfactionScore() {
        return customerSatisfactionScore;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
    // Getters and Setters
    public Map<String, Double> getAllocatedResources() {
        return allocatedResources;
    }

    public void setAllocatedResources(Map<String, Double> allocatedResources) {
        this.allocatedResources = allocatedResources;
    }
}
