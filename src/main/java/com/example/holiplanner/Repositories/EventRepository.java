package com.example.holiplanner.Repositories;

import com.example.holiplanner.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
