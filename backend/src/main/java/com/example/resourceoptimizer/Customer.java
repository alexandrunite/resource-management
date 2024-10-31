package com.example.resourceoptimizer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.Set;

@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String name;
    private String usagePattern;
    private int timeSensitivity;
    private double costEfficiency;
    // Additional fields
    // Getters and Setters
}
