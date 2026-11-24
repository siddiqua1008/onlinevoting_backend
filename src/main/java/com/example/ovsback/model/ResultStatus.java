package com.example.ovsback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class ResultStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean published;

    public ResultStatus() {}

    public ResultStatus(boolean published) {
        this.published = published;
    }

    public Long getId() { return id; }

    public boolean isPublished() { return published; }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
