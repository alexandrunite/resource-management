package com.example.resourceoptimizer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "scores")
public class Score {
    @Id
    private String id;
    private String userId;
    private int roundNumber;
    private double costEfficiencyScore;
    private double resourceUtilizationScore;
    private double customerSatisfactionScore;
    private double totalScore;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public int getRoundNumber() { return roundNumber; }
    public void setRoundNumber(int roundNumber) { this.roundNumber = roundNumber; }
    public double getCostEfficiencyScore() { return costEfficiencyScore; }
    public void setCostEfficiencyScore(double costEfficiencyScore) { this.costEfficiencyScore = costEfficiencyScore; }
    public double getResourceUtilizationScore() { return resourceUtilizationScore; }
    public void setResourceUtilizationScore(double resourceUtilizationScore) { this.resourceUtilizationScore = resourceUtilizationScore; }
    public double getCustomerSatisfactionScore() { return customerSatisfactionScore; }
    public void setCustomerSatisfactionScore(double customerSatisfactionScore) { this.customerSatisfactionScore = customerSatisfactionScore; }
    public double getTotalScore() { return totalScore; }
    public void setTotalScore(double totalScore) { this.totalScore = totalScore; }
}
