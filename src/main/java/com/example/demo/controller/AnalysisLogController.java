package com.example.demo.controller;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class AnalysisLogController {
    
    @Autowired
    private AnalysisLogService analysisLogService;
    
    @PostMapping
    public AnalysisLog addLog(@RequestParam Long zoneId, @RequestParam String message) {
        return analysisLogService.addLog(zoneId, message);
    }
    
    @GetMapping("/zone/{zoneId}")
    public List<AnalysisLog> getLogsByZone(@PathVariable Long zoneId) {
        return analysisLogService.getLogsByZone(zoneId);
    }
}