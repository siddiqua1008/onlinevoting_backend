package com.example.ovsback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ovsback.model.Voting;
import com.example.ovsback.service.ResultService;
import com.example.ovsback.service.VotingService;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/voting")
public class VotingController {

    @Autowired
    private VotingService votingService;
   

    @Autowired
    private ResultService resultService; 

    @GetMapping("/admin")
    public ResponseEntity<Map<String, Long>> getVoteCounts() {
        Map<String, Long> results = votingService.countVotesPerCandidate();
        return ResponseEntity.ok(results);
    }
    
    @PostMapping("/publish")
    public ResponseEntity<String> publishResults() {
        resultService.setPublished(true); // Just sets a boolean flag
        return ResponseEntity.ok("Results published to voters");
    }
    @GetMapping("/public")
    public ResponseEntity<Map<String, Long>> getPublicResults() {
        if (!resultService.isPublished()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Map<String, Long> results = votingService.countVotesPerCandidate();
        return ResponseEntity.ok(results);
    }


    @PostMapping
    public ResponseEntity<?> castVote(@RequestBody Voting voting) {
        System.out.println("Received Vote Request: " + voting);
        
        if (voting.getVoterEmail() == null || voting.getVoterEmail().isEmpty()) {
            System.out.println("Error: Missing voter email");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Voting newVote = votingService.castVote(voting);
            System.out.println("Vote Saved Successfully: " + newVote);
            return new ResponseEntity<>(newVote, HttpStatus.CREATED);
        }
        catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // Show duplicate vote error nicely
        }

        catch (Exception e) {
            System.out.println("Error Saving Vote: " + e.getMessage());
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public List<Voting> getAllVotes() {
        return votingService.getAllVotes();
    }

    @GetMapping("/candidate/{name}")
    public List<Voting> getVotesByCandidate(@PathVariable String name) {
        return votingService.getVotesByCandidate(name);
    }

    @GetMapping("/voter/{email}")
    public List<Voting> getVotesByVoter(@PathVariable String email) {
        return votingService.getVotesByVoter(email);
    }
}
