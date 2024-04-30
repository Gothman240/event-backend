package com.mindhub.backend.event.repositories;

import com.mindhub.backend.event.models.entities.EventLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventLocationRepository extends JpaRepository<EventLocation, Long> {
}