package com.example.ovsback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ovsback.model.Voting;
import com.example.ovsback.repository.VotingRepository;
import java.util.List;

@Service
public class VotingServiceImpl implements VotingService {

    @Autowired
    private VotingRepository votingRepo;

    @Override
    public Voting castVote(Voting voting) {
    	boolean alreadyVoted = votingRepo.existsByVoterEmailAndCandidateName(
                voting.getVoterEmail(), voting.getCandidateName());
    	 if (alreadyVoted) {
             throw new IllegalStateException("This email has already voted for this candidate.");
         }
        return votingRepo.save(voting);
    }

    @Override
    public List<Voting> getAllVotes() {
        return votingRepo.findAll();
    }

    @Override
    public List<Voting> getVotesByCandidate(String candidateName) {
        return votingRepo.findByCandidateName(candidateName);
    }

    @Override
    public List<Voting> getVotesByVoter(String voterEmail) {
        return votingRepo.findByVoterEmail(voterEmail);
    }
}

