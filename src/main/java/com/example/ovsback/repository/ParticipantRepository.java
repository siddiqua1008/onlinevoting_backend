package com.example.ovsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ovsback.model.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
