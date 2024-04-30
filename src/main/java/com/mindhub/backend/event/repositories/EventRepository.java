package com.mindhub.backend.event.repositories;

import com.mindhub.backend.event.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}