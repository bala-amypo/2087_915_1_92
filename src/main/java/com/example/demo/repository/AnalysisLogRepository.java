package com.example.demo.repository;

import com.example.demo.model.AnalysisLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisLogRepository
        extends JpaRepository<AnalysisLog, Long> {
}


