package com.example.resourceoptimizer.service;

import com.example.resourceoptimizer.Score;
import com.example.resourceoptimizer.User;
import com.example.resourceoptimizer.AllocationResult;
import com.example.resourceoptimizer.UserScore;
import com.example.resourceoptimizer.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    // Existing methods
    public List<Score> findByUserId(String userId) {
        return scoreRepository.findByUserId(userId);
    }

    public List<Score> findByRoundNumber(int roundNumber) {
        return scoreRepository.findByRoundNumber(roundNumber);
    }

    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }

    public void deleteScore(String id) {
        scoreRepository.deleteById(id);
    }

    public Optional<Score> getScoreById(String id) {
        return scoreRepository.findById(id);
    }

    // New method to calculate score based on AllocationResult
    public Score calculateScore(User user, AllocationResult allocationResult) {
        Score score = new Score();
        score.setUserId(user.getId());
        score.setRoundNumber(allocationResult.getRoundNumber());

        // Calculate individual scoring metrics
        score.setCostEfficiencyScore(calculateCostEfficiency(allocationResult));
        score.setResourceUtilizationScore(calculateResourceUtilization(allocationResult));
        score.setCustomerSatisfactionScore(calculateCustomerSatisfaction(allocationResult));

        // Calculate the total score by summing individual metrics
        score.setTotalScore(score.getCostEfficiencyScore() +
                score.getResourceUtilizationScore() +
                score.getCustomerSatisfactionScore());

        // Save and return the score
        return scoreRepository.save(score);
    }

    private double calculateCostEfficiency(AllocationResult result) {
        // Example calculation: Higher score for lower cost
        return result.getTotalCost() > 0 ? 1 / result.getTotalCost() : 0.0;
    }

    private double calculateResourceUtilization(AllocationResult result) {
        // Example calculation: percentage of resources utilized
        return (result.getResourcesUsed() / result.getTotalResources()) * 100;
    }

    private double calculateCustomerSatisfaction(AllocationResult result) {
        // Example placeholder calculation for customer satisfaction
        return result.getCustomerSatisfactionScore();
    }
    // New method to generate rankings by round number
    public List<UserScore> getUserRankings(int roundNumber) {
        List<Score> scores = scoreRepository.findByRoundNumber(roundNumber);

        // Convert Score objects to UserScore and sort by total score
        return scores.stream()
                .map(score -> new UserScore(score.getUserId(), score.getTotalScore()))
                .sorted(Comparator.comparingDouble(UserScore::getTotalScore).reversed())
                .collect(Collectors.toList());
    }

}
