package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.dto.MarketIndexResponse;
import com.harshith.marketintelligence.model.Result;
import com.harshith.marketintelligence.model.YahooResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketIndexApiService {

    @Autowired
    private RestTemplate restTemplate;

    private static class MarketIndex {

        String country;
        String name;
        String symbol;

        MarketIndex(String country, String name, String symbol) {
            this.country = country;
            this.name = name;
            this.symbol = symbol;
        }
    }

    private static final List<MarketIndex> INDICES = List.of(

            new MarketIndex("India","NIFTY 50","^NSEI"),
            new MarketIndex("India","SENSEX","^BSESN"),

            new MarketIndex("USA","S&P 500","^GSPC"),
            new MarketIndex("USA","NASDAQ Composite","^IXIC"),
            new MarketIndex("USA","Dow Jones","^DJI"),

            new MarketIndex("Japan","Nikkei 225","^N225"),
            new MarketIndex("UK","FTSE 100","^FTSE"),
            new MarketIndex("Germany","DAX","^GDAXI"),
            new MarketIndex("France","CAC 40","^FCHI"),

            new MarketIndex("Hong Kong","Hang Seng","^HSI"),

            new MarketIndex("Canada","S&P/TSX","^GSPTSE"),

            new MarketIndex("China","Shanghai Composite","000001.SS")
    );

    @Cacheable("market")
    public List<MarketIndexResponse> getMarketData() {

        List<MarketIndexResponse> responseList = new ArrayList<>();

        for (MarketIndex index : INDICES) {

            try {

                String url =
                        "https://query1.finance.yahoo.com/v8/finance/chart/"
                                + index.symbol;

                YahooResponse response =
                        restTemplate.getForObject(
                                url,
                                YahooResponse.class
                        );

                if (response == null ||
                        response.getChart() == null ||
                        response.getChart().getResult() == null ||
                        response.getChart().getResult().isEmpty()) {

                    continue;
                }

                Result result =
                        response.getChart()
                                .getResult()
                                .get(0);

                double price =
                        result.getMeta().getRegularMarketPrice();

                double previous =
                        result.getMeta().getPreviousClose();

                double change = 0;

                if (previous != 0) {

                    change =
                            ((price - previous)
                                    / previous)
                                    * 100;
                }

                MarketIndexResponse market =
                        new MarketIndexResponse();

                market.setCountry(index.country);
                market.setIndexName(index.name);
                market.setSymbol(index.symbol);

                market.setPrice(
                        Math.round(price * 100.0) / 100.0
                );

                market.setChangePercent(
                        Math.round(change * 100.0) / 100.0
                );

                responseList.add(market);

            } catch (Exception e) {

                System.out.println(
                        "Failed : "
                                + index.symbol
                                + " -> "
                                + e.getMessage()
                );
            }
        }

        return responseList;
    }
}