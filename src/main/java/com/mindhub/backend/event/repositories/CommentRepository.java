package com.mindhub.backend.event.repositories;

import com.mindhub.backend.event.models.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}