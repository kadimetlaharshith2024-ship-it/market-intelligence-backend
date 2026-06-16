package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.dto.MetalsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MetalApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${metal.api.key}")
    private String apiKey;
    @Cacheable("metals")
    public MetalsResponse getMetals() {

        String url =
                "https://api.metals.dev/v1/latest?api_key="
                        + apiKey;

        return restTemplate.getForObject(
                url,
                MetalsResponse.class
        );
    }
}