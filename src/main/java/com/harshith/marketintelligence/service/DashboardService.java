package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.dto.DashboardResponse;
import com.harshith.marketintelligence.dto.NewsDashboardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

@Service
public class DashboardService {

    @Autowired
    private MarketIndexApiService marketIndexApiService;

    @Autowired
    private MetalApiService metalApiService;

    @Autowired
    private OilApiService oilApiService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private RainfallService rainfallService;

    @Autowired
    private NewsApiService newsApiService;

    public DashboardResponse getDashboard() {

        DashboardResponse response =
                new DashboardResponse();

        response.setMarket(
                marketIndexApiService.getMarketData()
        );

        response.setMetals(
                metalApiService.getMetals()
        );

        response.setOil(
                oilApiService.getOilPrice()
        );

        response.setWeather(
                weatherService.getMumbaiWeather()
        );

        response.setRainfall(
                rainfallService.getPredictionReport()
        );

        response.setNews(
                getNews()
        );
        return response;
    }
    @Cacheable("news")
    public NewsDashboardResponse getNews() {

        NewsDashboardResponse news =
                new NewsDashboardResponse();

        news.setGoldNews(
                newsApiService.getGoldNews()
        );

        news.setSilverNews(
                newsApiService.getSilverNews()
        );

        news.setCopperNews(
                newsApiService.getCopperNews()
        );

        news.setAluminumNews(
                newsApiService.getAluminumNews()
        );

        news.setPlatinumNews(
                newsApiService.getPlatinumNews()
        );

        news.setOilNews(
                newsApiService.getOilNews()
        );

        return news;
    }
}