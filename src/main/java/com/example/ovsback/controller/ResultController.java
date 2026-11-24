package com.example.ovsback.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ovsback.service.ResultService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

  
    @GetMapping("/admin")
    public Map<Object, Long> getResultsForAdmin() {
        return resultService.calculateResults();
    }


    @PostMapping("/publish")
    public ResponseEntity<String> publishResults() {
        resultService.publishResults();
        return ResponseEntity.ok("Results Published");
    }

    
    @GetMapping("/all")
    public ResponseEntity<?> getResultsForVoters() {
        if (!resultService.isPublished()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Results not published");
        }
        return ResponseEntity.ok(resultService.calculateResults());
    }
    @GetMapping("/isPublished")
    public ResponseEntity<Boolean> isPublished() {
        return ResponseEntity.ok(resultService.isPublished());
    }
    @PostMapping("/resetPublish")
    public ResponseEntity<Void> resetPublish() {
        resultService.resetPublishStatus();
        return ResponseEntity.ok().build(); 
    }
    

        
    }






