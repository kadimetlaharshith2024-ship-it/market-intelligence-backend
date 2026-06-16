package com.harshith.marketintelligence.controller;

import com.harshith.marketintelligence.model.WeatherResponse;
import com.harshith.marketintelligence.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/mumbai")
    public WeatherResponse getMumbaiWeather() {
        return weatherService.getMumbaiWeather();
    }
}