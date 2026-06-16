package com.harshith.marketintelligence.controller;

import com.harshith.marketintelligence.dto.MetalsResponse;
import com.harshith.marketintelligence.service.MetalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetalApiController {

    @Autowired
    private MetalApiService metalApiService;

    @GetMapping("/api/metals")
    public MetalsResponse getMetals() {
        return metalApiService.getMetals();
    }
}