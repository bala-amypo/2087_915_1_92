package com.example.demo.service.impl;


import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {


private final PatternDetectionResultRepository repo;
private final HotspotZoneRepository zoneRepo;


public PatternDetectionServiceImpl(PatternDetectionResultRepository repo, HotspotZoneRepository zoneRepo) {
this.repo = repo;
this.zoneRepo = zoneRepo;
}

@Override
public PatternDetectionResult analyze(HotspotZone zone, int count) {
if (count < 0) throw new IllegalArgumentException("crimeCount must be non-negative");


String pattern;
String severity;
if (count >= 10) {
pattern = "High Density";
severity = "HIGH";
} else if (count >= 5) {
pattern = "Medium Density";
severity = "MEDIUM";
} else {
pattern = "Low Density";
severity = "LOW";
}


zone.setSeverityLevel(severity);
zoneRepo.save(zone);

PatternDetectionResult result = new PatternDetectionResult();
result.setZone(zone);
result.setCrimeCount(count);
result.setDetectedPattern(pattern);
result.setAnalysisDate(LocalDate.now());
return repo.save(result);
}
}