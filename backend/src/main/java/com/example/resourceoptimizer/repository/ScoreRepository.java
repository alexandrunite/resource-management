package com.example.resourceoptimizer.repository;

import com.example.resourceoptimizer.Score;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ScoreRepository extends MongoRepository<Score, String> {
    List<Score> findByRoundNumber(int roundNumber);
    List<Score> findByUserId(String userId);
}
