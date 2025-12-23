package com.example.demo.controller;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analysis-logs")
public class AnalysisLogController {

    private final AnalysisLogService service;

    public AnalysisLogController(AnalysisLogService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public AnalysisLog addLog(
            @RequestParam Long zoneId,
            @RequestParam String message) {

        return service.addLog(zoneId, message);
    }

    @GetMapping("/zone/{zoneId}")
    public List<AnalysisLog> getLogsByZone(@PathVariable Long zoneId) {
        return service.getLogsByZone(zoneId);
    }
}
