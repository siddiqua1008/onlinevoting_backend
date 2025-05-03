package com.example.ovsback.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ovsback.model.Participant;
import com.example.ovsback.service.ParticipantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping
    public ResponseEntity<Participant> saveParticipant(@RequestBody Participant participant) {
        return new ResponseEntity<>(participantService.save(participant), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Participant>> getAllParticipants() {
        return new ResponseEntity<>(participantService.getAllParticipants(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable int id) {
        return new ResponseEntity<>(participantService.getParticipantById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable int id) {
        participantService.deleteParticipant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
