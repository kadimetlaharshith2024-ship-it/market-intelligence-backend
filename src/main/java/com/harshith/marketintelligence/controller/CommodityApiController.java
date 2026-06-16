package com.harshith.marketintelligence.controller;

import com.harshith.marketintelligence.dto.CommodityQuoteResponse;
import com.harshith.marketintelligence.service.CommodityApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommodityApiController {

    @Autowired
    private CommodityApiService commodityApiService;

    @GetMapping("/commodity/gold")
    public CommodityQuoteResponse[] getGold() {
        return commodityApiService.getCommodity("GCUSD");
    }

    @GetMapping("/commodity/silver")
    public CommodityQuoteResponse[] getSilver() {
        return commodityApiService.getCommodity("SIUSD");
    }

    @GetMapping("/commodity/copper")
    public CommodityQuoteResponse[] getCopper() {
        return commodityApiService.getCommodity("HGUSD");
    }

    @GetMapping("/commodity/aluminium")
    public CommodityQuoteResponse[] getAluminium() {
        return commodityApiService.getCommodity("ALIUSD");
    }

    @GetMapping("/commodity/oil")
    public CommodityQuoteResponse[] getOil() {
        return commodityApiService.getCommodity("CLUSD");
    }
}