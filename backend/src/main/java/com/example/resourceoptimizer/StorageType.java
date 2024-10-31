package com.example.resourceoptimizer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.Set;

@Document(collection = "storage_types")
public class StorageType {
    @Id
    private String id;
    private String typeName;
    private double costPerUnit;
    private double capacity;
    // Getters and Setters
}
