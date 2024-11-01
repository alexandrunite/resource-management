package com.example.resourceoptimizer.service;

import com.example.resourceoptimizer.AllocationResult;
import com.example.resourceoptimizer.Event;
import com.example.resourceoptimizer.Round;
import com.example.resourceoptimizer.Score;
import com.example.resourceoptimizer.repository.RoundRepository;
import com.example.resourceoptimizer.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private EventService eventService;

    public Round executeRound(int roundNumber) {
        // Initialize a new round instance
        Round round = new Round();
        round.setRoundNumber(roundNumber);
        round.setStartTime(new Date());

        // Generate or fetch events for this round
        List<Event> events = eventService.generateEventsForRound(roundNumber);
        round.setEvents(events.stream().map(Event::getId).collect(Collectors.toList()));

        // Allocate resources based on current data and events
        AllocationResult allocationResult = allocationService.allocateResources();

        // Calculate and save scores based on the allocation result
        double score = calculateScore(allocationResult);  // Example method to calculate score
        saveScore(roundNumber, score);  // Save score for this round

        // Set end time for the round
        round.setEndTime(new Date());

        // Save the round to the repository
        roundRepository.save(round);

        return round;
    }

    private double calculateScore(AllocationResult allocationResult) {
        // Custom logic to calculate the score based on the allocation result
        // Example: score could be based on metrics like efficiency, utilization, etc.
        return allocationResult.getAllocatedResources().values().stream().mapToDouble(Double::doubleValue).sum();
    }

    private void saveScore(int roundNumber, double score) {
        Score roundScore = new Score();
        roundScore.setRoundNumber(roundNumber);
        roundScore.setTotalScore(score);
        scoreRepository.save(roundScore); // Save roundScore to repository
    }

    @Autowired
    public RoundService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    // Method to get a Round by ID
    public Optional<Round> getRoundById(String id) {
        return roundRepository.findById(id);
    }

    // Method to find Rounds by roundNumber
    public List<Round> findByRoundNumber(int roundNumber) {
        return roundRepository.findByRoundNumber(roundNumber);
    }

    // Method to save a Round
    public Round saveRound(Round round) {
        return roundRepository.save(round);
    }

    // Method to delete a Round by ID
    public void deleteRound(String id) {
        roundRepository.deleteById(id);
    }
}
