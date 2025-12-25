package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PatternDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {
    
    @Autowired
    private HotspotZoneRepository zoneRepository;
    
    @Autowired
    private CrimeReportRepository reportRepository;
    
    @Autowired
    private PatternDetectionResultRepository resultRepository;
    
    @Autowired
    private AnalysisLogRepository logRepository;
    
    public PatternDetectionServiceImpl(HotspotZoneRepository zoneRepository, 
                                     CrimeReportRepository reportRepository,
                                     PatternDetectionResultRepository resultRepository,
                                     AnalysisLogRepository logRepository) {
        this.zoneRepository = zoneRepository;
        this.reportRepository = reportRepository;
        this.resultRepository = resultRepository;
        this.logRepository = logRepository;
    }
    
    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        HotspotZone zone = zoneRepository.findById(zoneId)
            .orElseThrow(() -> new RuntimeException("Zone not found"));
        
        double minLat = zone.getCenterLat() - 0.1;
        double maxLat = zone.getCenterLat() + 0.1;
        double minLong = zone.getCenterLong() - 0.1;
        double maxLong = zone.getCenterLong() + 0.1;
        
        List<CrimeReport> reports = reportRepository.findByLatLongRange(minLat, maxLat, minLong, maxLong);
        
        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);
        result.setCrimeCount(reports.size());
        result.setAnalysisDate(LocalDate.now());
        
        String pattern;
        if (reports.size() >= 10) {
            pattern = "High crime pattern detected";
            zone.setSeverityLevel("HIGH");
        } else if (reports.size() >= 5) {
            pattern = "Medium crime pattern detected";
            zone.setSeverityLevel("MEDIUM");
        } else {
            pattern = "No significant pattern detected";
            zone.setSeverityLevel("LOW");
        }
        
        result.setDetectedPattern(pattern);
        
        AnalysisLog log = new AnalysisLog();
        log.setZone(zone);
        log.setMessage("Pattern detection completed for zone " + zone.getZoneName());
        log.setLoggedAt(LocalDateTime.now());
        
        logRepository.save(log);
        zoneRepository.save(zone);
        return resultRepository.save(result);
    }
    
    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepository.findByZone_Id(zoneId);
    }
}