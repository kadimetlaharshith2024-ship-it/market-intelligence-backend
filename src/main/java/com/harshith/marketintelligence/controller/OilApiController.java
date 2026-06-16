package com.harshith.marketintelligence.controller;

import com.harshith.marketintelligence.model.OilResponse;
import com.harshith.marketintelligence.service.OilApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OilApiController {

    @Autowired
    private OilApiService oilApiService;

    @GetMapping("/api/oil")
    public OilResponse getOilPrice() {
        return oilApiService.getOilPrice();
    }
}