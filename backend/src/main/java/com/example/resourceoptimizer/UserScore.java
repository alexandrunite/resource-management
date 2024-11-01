package com.example.resourceoptimizer;

public class UserScore {
    private String userId;
    private double totalScore;

    // Constructor
    public UserScore(String userId, double totalScore) {
        this.userId = userId;
        this.totalScore = totalScore;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }
}
