package com.harshith.marketintelligence.controller;

import com.harshith.marketintelligence.dto.MarketIndexResponse;
import com.harshith.marketintelligence.service.MarketIndexApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarketIndexApiController {

    @Autowired
    private MarketIndexApiService marketIndexApiService;

    @GetMapping("/api/market")
    public List<MarketIndexResponse> getMarketData() {
        return marketIndexApiService.getMarketData();
    }
}