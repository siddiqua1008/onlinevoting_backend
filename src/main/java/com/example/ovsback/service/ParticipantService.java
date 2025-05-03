package com.example.ovsback.service;

import java.util.List;
import com.example.ovsback.model.Participant;

public interface ParticipantService {
	Participant save(Participant participant);
    List<Participant> getAllParticipants();
    Participant getParticipantById(int id);
    void deleteParticipant(int id);
}
