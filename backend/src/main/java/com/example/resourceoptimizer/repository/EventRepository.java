package com.example.resourceoptimizer.repository;

import com.example.resourceoptimizer.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByLocation(String location);

    List<Event> findByRoundNumber(int roundNumber);
}
