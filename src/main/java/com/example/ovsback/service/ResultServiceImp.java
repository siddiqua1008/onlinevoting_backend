package com.example.ovsback.service;

import com.example.ovsback.model.ResultStatus;
import com.example.ovsback.model.Voting;
import com.example.ovsback.repository.ResultStatusRepository;
import com.example.ovsback.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResultServiceImp implements ResultService {

    @Autowired
    private VotingRepository votingRepository;

    @Autowired
    private ResultStatusRepository resultStatusRepository;

    
    private boolean published = false;

    
    @Override
    public void resetPublishStatus() {
        resultStatusRepository.deleteAll(); 
        resultStatusRepository.save(new ResultStatus(false));
    }

    @Override
    public Map<Object, Long> calculateResults() {
        return votingRepository.findAll().stream()
            .collect(Collectors.groupingBy(
                Voting::getCandidateName,
                Collectors.counting()
            ));
    }



    @Override
    public void publishResults() {
        resultStatusRepository.deleteAll(); 
        resultStatusRepository.save(new ResultStatus(true));
    }

    @Override
    public boolean isPublished() {
        return resultStatusRepository.findAll().stream()
                .reduce((first, second) -> second) // get the latest
                .map(ResultStatus::isPublished)
                .orElse(false);
    }

    @Override
    public void setPublished(boolean published) {
        resultStatusRepository.deleteAll();
        resultStatusRepository.save(new ResultStatus(published));
    }
}

