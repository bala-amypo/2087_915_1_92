package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.model.HotspotZone;
import com.example.demo.model.PatternDetectionResult;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.repository.PatternDetectionResultRepository;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {

    private final HotspotZoneRepository zoneRepo;
    private final CrimeReportRepository reportRepo;
    private final PatternDetectionResultRepository resultRepo;
    private final AnalysisLogRepository logRepo;

    public PatternDetectionServiceImpl(HotspotZoneRepository zoneRepo,
                                       CrimeReportRepository reportRepo,
                                       PatternDetectionResultRepository resultRepo,
                                       AnalysisLogRepository logRepo) {
        this.zoneRepo = zoneRepo;
        this.reportRepo = reportRepo;
        this.resultRepo = resultRepo;
        this.logRepo = logRepo;
    }

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        HotspotZone zone = zoneRepo.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        // Dummy detection: count reports within 0.5 degree radius
        List<CrimeReport> reports = reportRepo.findByLatLongRange(
                zone.getCenterLat() - 0.5,
                zone.getCenterLat() + 0.5,
                zone.getCenterLong() - 0.5,
                zone.getCenterLong() + 0.5
        );

        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);
        result.setCrimeCount(reports.size());

        String pattern;
        if (reports.size() >= 10) pattern = "High severity pattern";
        else if (reports.size() >= 1) pattern = "Medium severity pattern";
        else pattern = "No pattern detected";

        result.setDetectedPattern(pattern);
        result.setAnalysisDate(java.time.LocalDate.now());

        // Save result
        resultRepo.save(result);

        // Log analysis
        logRepo.save(new com.example.demo.model.AnalysisLog(zone, "Pattern detected: " + pattern));

        return result;
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepo.findByZone_Id(zoneId);
    }
}
