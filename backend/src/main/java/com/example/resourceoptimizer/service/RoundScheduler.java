package com.example.resourceoptimizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RoundScheduler {

    @Autowired
    private RoundService roundService;

    private int currentRound = 1;
    private final int maxRounds = 42; // Adjust this based on the competition duration or requirements

    @Scheduled(fixedRate = 60000) // Executes every 60 seconds for demonstration purposes
    public void scheduleRounds() {
        if (currentRound > maxRounds) {
            // Stop scheduling or handle end of rounds
            return;
        }

        // Execute the round with the current round number
        roundService.executeRound(currentRound);

        // Increment to the next round
        currentRound++;
    }
}
