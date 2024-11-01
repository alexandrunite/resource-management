package com.example.resourceoptimizer.repository;

import com.example.resourceoptimizer.Round;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RoundRepository extends MongoRepository<Round, String> {
    List<Round> findByRoundNumber(int roundNumber);
}
