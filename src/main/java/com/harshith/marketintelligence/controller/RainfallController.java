package com.harshith.marketintelligence.controller;

import com.harshith.marketintelligence.model.Rainfall;
import com.harshith.marketintelligence.dto.RainfallPredictionResponse;
import com.harshith.marketintelligence.service.RainfallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RainfallController {

    @Autowired
    private RainfallService rainfallService;

    @GetMapping("/rainfall")
    public List<Rainfall> getAllRainfallData() {
        return rainfallService.getAllRainfallData();
    }

    @PostMapping("/rainfall")
    public Rainfall addRainfall(@RequestBody Rainfall rainfall) {
        return rainfallService.saveRainfall(rainfall);
    }

    @GetMapping("/rainfall/predict")
    public RainfallPredictionResponse predictRainfall() {

        return rainfallService.getPredictionReport();
    }
}