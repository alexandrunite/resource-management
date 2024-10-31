package com.example.resourceoptimizer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.Set;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private List<String> roles;
    // Getters and Setters
}
