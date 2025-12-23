package com.example.demo.service.impl;

import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;

@Service  
public class PatternDetectionServiceImpl implements PatternDetectionService {

    @Override
    public String detectPattern(Long zoneId) {
        return "Pattern detected for zone " + zoneId;
    }
}
