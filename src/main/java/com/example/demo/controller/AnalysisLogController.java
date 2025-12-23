package com.example.demo.controller;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisLogController {

    private final AnalysisLogService logService;

    @Autowired
    public AnalysisLogController(AnalysisLogService logService) {
        this.logService = logService;
    }

    // --- Add a log to a specific hotspot zone
    @PostMapping("/zone/{zoneId}")
    public ResponseEntity<AnalysisLog> addLog(@PathVariable Long zoneId,
                                              @RequestParam String message) {
        AnalysisLog log = logService.addLog(zoneId, message);
        return ResponseEntity.ok(log);
    }

    // --- Get all logs for a specific zone
    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<AnalysisLog>> getLogsByZone(@PathVariable Long zoneId) {
        List<AnalysisLog> logs = logService.getLogsByZone(zoneId);
        return ResponseEntity.ok(logs);
    }
}
