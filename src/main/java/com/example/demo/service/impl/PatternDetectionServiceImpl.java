package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.model.HotspotZone;
import com.example.demo.model.PatternDetectionResult;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.repository.PatternDetectionResultRepository;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.model.AnalysisLog;
import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {

    private final HotspotZoneRepository zoneRepo;
    private final CrimeReportRepository reportRepo;
    private final PatternDetectionResultRepository resultRepo;
    private final AnalysisLogRepository logRepo;

    public PatternDetectionServiceImpl(HotspotZoneRepository zoneRepo, CrimeReportRepository reportRepo,
                                       PatternDetectionResultRepository resultRepo, AnalysisLogRepository logRepo) {
        this.zoneRepo = zoneRepo;
        this.reportRepo = reportRepo;
        this.resultRepo = resultRepo;
        this.logRepo = logRepo;
    }

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        HotspotZone zone = zoneRepo.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        // Example: fetch reports within some range (mocked)
        List<CrimeReport> reports = reportRepo.findByLatLongRange(
                zone.getCenterLat() - 0.01, zone.getCenterLat() + 0.01,
                zone.getCenterLong() - 0.01, zone.getCenterLong() + 0.01
        );

        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);                         // HotspotZone
        result.setCrimeCount(reports.size());         // Integer
        result.setDetectedPattern(
                reports.size() > 5 ? "High" :
                reports.size() > 0 ? "Medium" : "No pattern"
        );                                           // String
        result.setAnalysisDate(LocalDate.now());

        // Save result
        PatternDetectionResult savedResult = resultRepo.save(result);

        // Save log
        AnalysisLog log = new AnalysisLog();
        log.setZone(zone);
        log.setMessage("Pattern detected: " + savedResult.getDetectedPattern());
        log.setLoggedAt(java.time.LocalDateTime.now());
        logRepo.save(log);

        return savedResult;
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepo.findByZone_Id(zoneId);
    }
}
