package com.example.ovsback.service;

import com.example.ovsback.model.Voting;
import java.util.List;
import java.util.Map;

public interface VotingService {
    Voting castVote(Voting voting);
    List<Voting> getAllVotes();
    List<Voting> getVotesByCandidate(String candidateName);
    List<Voting> getVotesByVoter(String voterEmail);
	Map<String, Long> countVotesPerCandidate();
}


