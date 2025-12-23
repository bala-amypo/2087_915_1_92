package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.model.HotspotZone;
import com.example.demo.model.PatternDetectionResult;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.repository.PatternDetectionResultRepository;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.service.PatternDetectionService;
import com.example.demo.service.AnalysisLogService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        Optional<HotspotZone> optionalZone = zoneRepo.findById(zoneId);
        if (optionalZone.isEmpty()) {
            throw new RuntimeException("Zone not found with id: " + zoneId);
        }

        HotspotZone zone = optionalZone.get();

        // Example: find reports within +/- 0.5 lat/lon
        double latMin = zone.getCenterLat() - 0.5;
        double latMax = zone.getCenterLat() + 0.5;
        double lonMin = zone.getCenterLong() - 0.5;
        double lonMax = zone.getCenterLong() + 0.5;

        List<CrimeReport> reports = reportRepo.findByLatLongRange(latMin, latMax, lonMin, lonMax);

        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone); // associate zone
        result.setCrimeCount(reports.size());
        
        if (reports.isEmpty()) {
            result.setDetectedPattern("No Pattern");
        } else if (reports.size() > 10) {
            result.setDetectedPattern("High Crime Pattern");
        } else {
            result.setDetectedPattern("Medium Crime Pattern");
        }

        result.setAnalysisDate(LocalDate.now());
        resultRepo.save(result);

        return result;
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepo.findByZone_Id(zoneId);
    }
}
