package com.harshith.marketintelligence.dto;

import com.harshith.marketintelligence.model.OilResponse;
import com.harshith.marketintelligence.dto.RainfallPredictionResponse;
import com.harshith.marketintelligence.model.WeatherResponse;

import java.util.List;

public class DashboardResponse {

    private List<MarketIndexResponse> market;
    private MetalsResponse metals;
    private OilResponse oil;
    private WeatherResponse weather;
    private RainfallPredictionResponse rainfall;
    private NewsDashboardResponse news;

    public List<MarketIndexResponse> getMarket() {
        return market;
    }

    public void setMarket(List<MarketIndexResponse> market) {
        this.market = market;
    }

    public MetalsResponse getMetals() {
        return metals;
    }

    public void setMetals(MetalsResponse metals) {
        this.metals = metals;
    }

    public OilResponse getOil() {
        return oil;
    }

    public void setOil(OilResponse oil) {
        this.oil = oil;
    }

    public WeatherResponse getWeather() {
        return weather;
    }

    public void setWeather(WeatherResponse weather) {
        this.weather = weather;
    }

    public RainfallPredictionResponse getRainfall() {
        return rainfall;
    }

    public void setRainfall(RainfallPredictionResponse rainfall) {
        this.rainfall = rainfall;
    }

    public NewsDashboardResponse getNews() {
        return news;
    }

    public void setNews(NewsDashboardResponse news) {
        this.news = news;
    }
}