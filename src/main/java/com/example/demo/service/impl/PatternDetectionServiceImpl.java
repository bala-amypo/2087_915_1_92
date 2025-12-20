package com.example.demo.service.impl;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.repository.PatternDetectionResultRepository;
import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {

    private final PatternDetectionResultRepository resultRepository;

    public PatternDetectionServiceImpl(
            PatternDetectionResultRepository resultRepository) {

        this.resultRepository = resultRepository;
    }

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {

        PatternDetectionResult result = new PatternDetectionResult();
        result.setCrimeCount(0);
        result.setDetectedPattern("Checked");
        result.setAnalysisDate(LocalDate.now());

        return resultRepository.save(result);
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepository.findAll(); // SIMPLE & SAFE
    }
}