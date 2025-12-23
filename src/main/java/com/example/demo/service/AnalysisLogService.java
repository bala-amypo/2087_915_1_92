package com.example.demo.service;

import com.example.demo.model.AnalysisLog;
import com.example.demo.repository.AnalysisLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnalysisLogService {

    private final AnalysisLogRepository repository;

    public AnalysisLogService(AnalysisLogRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public AnalysisLog createLog(String description) {
        AnalysisLog log = new AnalysisLog();
        log.setDescription(description);
        // timestamp is auto-set
        return repository.save(log);
    }
}
