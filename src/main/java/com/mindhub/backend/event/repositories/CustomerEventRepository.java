package com.mindhub.backend.event.repositories;

import com.mindhub.backend.event.models.entities.CustomerEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEventRepository extends JpaRepository<CustomerEvent, Long> {
}