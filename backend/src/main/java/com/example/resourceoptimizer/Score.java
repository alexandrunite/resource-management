package com.example.resourceoptimizer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.Set;

import java.util.Date;

import java.util.List;


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
}
