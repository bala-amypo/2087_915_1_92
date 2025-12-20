package com.example.demo.repository;

import com.example.demo.model.PatternDetectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatternDetectionResultRepository
        extends JpaRepository<PatternDetectionResult, Long> {
}