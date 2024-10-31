package com.example.resourceoptimizer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import lombok.Data;

import java.util.Set;

@Document(collection = "events")
public class Event {
    @Id
    private String id;
    private String roundId;
    private String description;
    private String eventType;
    private Date eventDate;
    // Getters and Setters
}

