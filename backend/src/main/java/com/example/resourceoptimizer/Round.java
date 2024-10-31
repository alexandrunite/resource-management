package com.example.resourceoptimizer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import lombok.Data;

import java.util.Set;
import java.util.List;

@Document(collection = "rounds")
public class Round {
    @Id
    private String id;
    private int roundNumber;
    private Date startTime;
    private Date endTime;
    private List<String> events;
    // Getters and Setters
}

