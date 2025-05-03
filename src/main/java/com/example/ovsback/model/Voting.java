package com.example.ovsback.model;

import jakarta.persistence.*;

@Entity
@Table(name = "voting") 
public class Voting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id;

    @Column(nullable = false) 
    private String voterEmail;

    @Column(nullable = false) 
    private String candidateName;

    public Voting() {
    }

    public Voting(String voterEmail, String candidateName) {
        this.voterEmail = voterEmail;
        this.candidateName = candidateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoterEmail() {
        return voterEmail;
    }

    public void setVoterEmail(String voterEmail) {
        this.voterEmail = voterEmail;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }
}


