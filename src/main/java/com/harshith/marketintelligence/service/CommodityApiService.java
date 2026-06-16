package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.dto.CommodityQuoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommodityApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${fmp.api.key}")
    private String apiKey;

    public CommodityQuoteResponse[] getCommodity(String symbol) {

        String url =
                "https://financialmodelingprep.com/stable/quote?symbol="
                        + symbol
                        + "&apikey="
                        + apiKey;

        return restTemplate.getForObject(
                url,
                CommodityQuoteResponse[].class
        );
    }
}