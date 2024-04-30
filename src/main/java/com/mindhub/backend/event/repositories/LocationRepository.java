package com.mindhub.backend.event.repositories;

import com.mindhub.backend.event.models.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}