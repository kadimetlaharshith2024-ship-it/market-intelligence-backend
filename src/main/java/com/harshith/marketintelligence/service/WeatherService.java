package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openweather.api.key}")
    private String apiKey;
    @Cacheable("weather")
    public WeatherResponse getMumbaiWeather() {

        String url =
                "https://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid="
                        + apiKey
                        + "&units=metric";

        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}