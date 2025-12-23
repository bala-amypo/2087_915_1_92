package com.example.demo.service.impl;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.repository.PatternDetectionResultRepository;
import com.example.demo.service.PatternDetectionService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {

    private final HotspotZoneRepository hotspotZoneRepository;
    private final CrimeReportRepository crimeReportRepository;
    private final PatternDetectionResultRepository resultRepository;
    private final AnalysisLogRepository analysisLogRepository;

    public PatternDetectionServiceImpl(
            HotspotZoneRepository hotspotZoneRepository,
            CrimeReportRepository crimeReportRepository,
            PatternDetectionResultRepository resultRepository,
            AnalysisLogRepository analysisLogRepository) {

        this.hotspotZoneRepository = hotspotZoneRepository;
        this.crimeReportRepository = crimeReportRepository;
        this.resultRepository = resultRepository;
        this.analysisLogRepository = analysisLogRepository;
    }

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        int count = crimeReportRepository.countByZoneId(zoneId);

        PatternDetectionResult result = new PatternDetectionResult();
        result.setZoneId(zoneId);
        result.setCrimeCount(count);
        result.setDetectedPattern(count > 10 ? "HIGH_CRIME" : "LOW_CRIME");

        return resultRepository.save(result);
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(long zoneId) {
        return resultRepository.findByZoneId(zoneId);
    }
} 