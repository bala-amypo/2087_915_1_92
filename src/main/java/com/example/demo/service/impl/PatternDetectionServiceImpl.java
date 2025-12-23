package com.example.demo.service.impl;

import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class PatternDetectionServiceImpl {

    public PatternDetectionServiceImpl(
            HotspotZoneRepository zoneRepo,
            CrimeReportRepository reportRepo,
            PatternDetectionResultRepository resultRepo,
            AnalysisLogRepository logRepo) {
    }
}
