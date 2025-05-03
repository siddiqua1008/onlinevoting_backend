package com.example.ovsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.ovsback.model.Voting;
import java.util.List;
import java.util.Map;

@Repository
public interface VotingRepository extends JpaRepository<Voting, Integer> {
    List<Voting> findByCandidateName(String candidateName);
    List<Voting> findByVoterEmail(String voterEmail);
    
    boolean existsByVoterEmailAndCandidateName(String voterEmail, String candidateName);

    
}


