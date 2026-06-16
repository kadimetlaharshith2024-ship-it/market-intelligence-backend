package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.model.Meta;
import com.harshith.marketintelligence.model.OilResponse;
import com.harshith.marketintelligence.model.YahooResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OilApiService {

    @Autowired
    private RestTemplate restTemplate;
    @Cacheable("oil")
    public OilResponse getOilPrice() {

        String url =
                "https://query1.finance.yahoo.com/v8/finance/chart/CL=F";

        HttpHeaders headers = new HttpHeaders();
        headers.set(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
        );
        headers.set(
                "Accept",
                "application/json"
        );

        HttpEntity<String> entity =
                new HttpEntity<>(headers);

        ResponseEntity<YahooResponse> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        entity,
                        YahooResponse.class
                );

        Meta meta =
                response.getBody()
                        .getChart()
                        .getResult()
                        .get(0)
                        .getMeta();

        OilResponse oilResponse =
                new OilResponse();

        oilResponse.setSymbol(meta.getSymbol());
        oilResponse.setCurrentPrice(meta.getRegularMarketPrice());
        oilResponse.setPreviousClose(meta.getPreviousClose());
        oilResponse.setDayHigh(meta.getRegularMarketDayHigh());
        oilResponse.setDayLow(meta.getRegularMarketDayLow());
        oilResponse.setVolume(meta.getRegularMarketVolume());
        oilResponse.setFiftyTwoWeekHigh(meta.getFiftyTwoWeekHigh());
        oilResponse.setFiftyTwoWeekLow(meta.getFiftyTwoWeekLow());

        return oilResponse;
    }
}