package com.example.resourceoptimizer.model;

import lombok.Getter;

@Getter
public class AuthentificationResponse {
    private final String jwt;

    public AuthentificationResponse(String jwt) {
        this.jwt = jwt;
    }

}