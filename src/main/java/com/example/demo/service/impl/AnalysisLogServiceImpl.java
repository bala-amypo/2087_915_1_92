package com.example.demo.service.impl;

import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.AnalysisLogService;
import org.springframework.stereotype.Service;

@Service
public class AnalysisLogServiceImpl implements AnalysisLogService {

    private final AnalysisLogRepository logRepo;
    private final HotspotZoneRepository zoneRepo;

    public AnalysisLogServiceImpl(
            AnalysisLogRepository logRepo,
            HotspotZoneRepository zoneRepo) {

        this.logRepo = logRepo;
        this.zoneRepo = zoneRepo;
    }
}
