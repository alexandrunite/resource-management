package com.example.resourceoptimizer.controller;

import com.example.resourceoptimizer.Round;
import com.example.resourceoptimizer.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rounds")
public class RoundController {

    private final RoundService roundService;

    @Autowired
    public RoundController(RoundService roundService) {
        this.roundService = roundService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Round> getRoundById(@PathVariable String id) {
        Optional<Round> round = roundService.getRoundById(id);
        return round.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/roundNumber/{roundNumber}")
    public ResponseEntity<List<Round>> getRoundsByRoundNumber(@PathVariable int roundNumber) {
        List<Round> rounds = roundService.findByRoundNumber(roundNumber);
        return ResponseEntity.ok(rounds);
    }

    @PostMapping
    public ResponseEntity<Round> createRound(@RequestBody Round round) {
        Round createdRound = roundService.saveRound(round);
        return ResponseEntity.ok(createdRound);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRound(@PathVariable String id) {
        roundService.deleteRound(id);
        return ResponseEntity.noContent().build();
    }
}
