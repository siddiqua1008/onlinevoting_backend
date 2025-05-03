package com.example.ovsback.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ovsback.exception.ResourceNotFoundException;
import com.example.ovsback.model.Participant;
import com.example.ovsback.repository.ParticipantRepository;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    @Override
    public Participant getParticipantById(int id) {
        return participantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Participant not found with id " + id));
    }

    @Override
    public void deleteParticipant(int id) {
       Participant participant = participantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Participant not found with id " + id));
        participantRepository.delete(participant);
    }
}
