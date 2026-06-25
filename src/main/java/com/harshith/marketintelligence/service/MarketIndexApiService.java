package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.dto.MarketIndexResponse;
import com.harshith.marketintelligence.model.Meta;
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

            new MarketIndex("India", "NIFTY 50", "^NSEI"),
            new MarketIndex("India", "SENSEX", "^BSESN"),

            new MarketIndex("USA", "S&P 500", "^GSPC"),
            new MarketIndex("USA", "NASDAQ Composite", "^IXIC"),
            new MarketIndex("USA", "Dow Jones", "^DJI"),

            new MarketIndex("Japan", "Nikkei 225", "^N225"),
            new MarketIndex("UK", "FTSE 100", "^FTSE"),
            new MarketIndex("Germany", "DAX", "^GDAXI"),
            new MarketIndex("France", "CAC 40", "^FCHI"),

            new MarketIndex("Hong Kong", "Hang Seng", "^HSI"),

            new MarketIndex("Canada", "S&P/TSX", "^GSPTSE"),

            new MarketIndex("China", "Shanghai Composite", "000001.SS")
    );

    @Cacheable("market")
    public List<MarketIndexResponse> getMarketData() {

        List<MarketIndexResponse> responseList = new ArrayList<>();

        for (MarketIndex index : INDICES) {

            try {

                String url =
                        "https://query1.finance.yahoo.com/v8/finance/chart/"
                                + index.symbol;

                System.out.println("Calling : " + url);

                YahooResponse response =
                        restTemplate.getForObject(
                                url,
                                YahooResponse.class
                        );

                if (response == null) {
                    System.out.println("Response is NULL");
                    continue;
                }

                if (response.getChart() == null) {
                    System.out.println("Chart is NULL");
                    continue;
                }

                if (response.getChart().getResult() == null) {
                    System.out.println("Result list is NULL");
                    continue;
                }

                if (response.getChart().getResult().isEmpty()) {
                    System.out.println("Result list is EMPTY");
                    continue;
                }

                Result result =
                        response.getChart()
                                .getResult()
                                .get(0);

                if (result == null) {
                    System.out.println("Result object is NULL");
                    continue;
                }

                Meta meta = result.getMeta();

                if (meta == null) {
                    System.out.println("Meta is NULL");
                    continue;
                }

                double price = meta.getRegularMarketPrice();
                double previous = meta.getPreviousClose();

                double change = 0;

                if (previous != 0) {
                    change = ((price - previous) / previous) * 100;
                }

                MarketIndexResponse market =
                        new MarketIndexResponse();

                market.setCountry(index.country);
                market.setIndexName(index.name);
                market.setSymbol(index.symbol);
                market.setPrice(Math.round(price * 100.0) / 100.0);
                market.setChangePercent(Math.round(change * 100.0) / 100.0);

                responseList.add(market);

                System.out.println("SUCCESS : " + index.symbol);

            } catch (Exception e) {

                System.out.println("====================================");
                System.out.println("FAILED SYMBOL : " + index.symbol);
                e.printStackTrace();
                System.out.println("====================================");
            }
        }

        return responseList;
    }
}