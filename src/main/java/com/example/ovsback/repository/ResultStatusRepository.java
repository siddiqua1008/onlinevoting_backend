package com.example.ovsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ovsback.model.ResultStatus;

@Repository
public interface ResultStatusRepository extends JpaRepository<ResultStatus, Long> {}

