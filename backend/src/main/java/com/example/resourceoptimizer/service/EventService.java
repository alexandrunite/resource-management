package com.example.resourceoptimizer.service;

import com.example.resourceoptimizer.Event;
import com.example.resourceoptimizer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findByLocation(String location) {
        return eventRepository.findByLocation(location);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }

    public List<Event> generateEventsForRound(int roundNumber) {
        List<Event> events = new ArrayList<>();

//        // Example: Generate new events for the round based on round number
//        Event event1 = new Event();
//        event1.setId("event_" + roundNumber + "_1");
//        event1.setName("Event 1 for Round " + roundNumber);
//        event1.setDescription("Description for event 1 in round " + roundNumber);
//        event1.setImpactFactor(roundNumber * 0.1); // Custom impact based on round number
//
//        Event event2 = new Event();
//        event2.setId("event_" + roundNumber + "_2");
//        event2.setName("Event 2 for Round " + roundNumber);
//        event2.setDescription("Description for event 2 in round " + roundNumber);
//        event2.setImpactFactor(roundNumber * 0.2);
//
//        // Add generated events to the list
//        events.add(event1);
//        events.add(event2);

        // Alternatively, you can fetch events from the repository based on roundNumber
        events = eventRepository.findByRoundNumber(roundNumber);

        return events;
    }
}
