package com.example.demo.service;

import com.example.demo.model.AnalysisLog;
import java.util.List;

public interface AnalysisLogService {

    List<AnalysisLog> getLogsByZone(Long zoneId);

    AnalysisLog addLog(Long zoneId, String message);
}
