package com.example.resourceoptimizer.controller;

import com.example.resourceoptimizer.Score;
import com.example.resourceoptimizer.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable String id) {
        Optional<Score> score = scoreService.getScoreById(id);
        return score.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Score>> getScoresByUserId(@PathVariable String userId) {
        List<Score> scores = scoreService.findByUserId(userId);
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/round/{roundNumber}")
    public ResponseEntity<List<Score>> getScoresByRoundNumber(@PathVariable int roundNumber) {
        List<Score> scores = scoreService.findByRoundNumber(roundNumber);
        return ResponseEntity.ok(scores);
    }

    @PostMapping
    public ResponseEntity<Score> createScore(@RequestBody Score score) {
        Score createdScore = scoreService.saveScore(score);
        return ResponseEntity.ok(createdScore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable String id) {
        scoreService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }
}
