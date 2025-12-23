package com.example.demo.controller;

import com.example.demo.model.PatternDetectionResult;   // ✅ IMPORTANT
import com.example.demo.service.PatternDetectionService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pattern")
public class PatternDetectionController {

    private final PatternDetectionService patternDetectionService;

    // ✅ constructor injection (variable error fix)
    public PatternDetectionController(PatternDetectionService patternDetectionService) {
        this.patternDetectionService = patternDetectionService;
    }

    @GetMapping("/detect/{zoneId}")
    public PatternDetectionResult detect(@PathVariable Long zoneId) {
        return patternDetectionService.detectPattern(zoneId);
    }
}
