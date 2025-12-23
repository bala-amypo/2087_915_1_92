package com.example.demo.service.impl;

import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class AnalysisLogServiceImpl {

    public AnalysisLogServiceImpl(
            AnalysisLogRepository logRepo,
            HotspotZoneRepository zoneRepo) {
    }
}
