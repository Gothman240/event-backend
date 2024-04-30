package com.mindhub.backend.event.repositories;

import com.mindhub.backend.event.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}