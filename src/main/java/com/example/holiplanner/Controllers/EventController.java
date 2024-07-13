package com.example.holiplanner.Controllers;

import com.example.holiplanner.Entities.Event;
import com.example.holiplanner.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leaves")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Event event = eventRepository.findById(id).orElse(null);

        event.setTitle(eventDetails.getTitle());
        event.setStart(eventDetails.getStart());
        event.setEnd(eventDetails.getEnd());
        event.setDescription(eventDetails.getDescription());

        return eventRepository.save(event);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEvent(@PathVariable Long id) {
        Event event = eventRepository.findById(id).orElse(null);

        eventRepository.delete(event);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

