package com.harshith.marketintelligence.dto;

import com.harshith.marketintelligence.model.Article;

import java.util.List;

public class NewsDashboardResponse {

    private List<Article> goldNews;
    private List<Article> silverNews;
    private List<Article> copperNews;
    private List<Article> aluminumNews;
    private List<Article> platinumNews;
    private List<Article> oilNews;

    public List<Article> getGoldNews() {
        return goldNews;
    }

    public void setGoldNews(List<Article> goldNews) {
        this.goldNews = goldNews;
    }

    public List<Article> getSilverNews() {
        return silverNews;
    }

    public void setSilverNews(List<Article> silverNews) {
        this.silverNews = silverNews;
    }

    public List<Article> getCopperNews() {
        return copperNews;
    }

    public void setCopperNews(List<Article> copperNews) {
        this.copperNews = copperNews;
    }

    public List<Article> getAluminumNews() {
        return aluminumNews;
    }

    public void setAluminumNews(List<Article> aluminumNews) {
        this.aluminumNews = aluminumNews;
    }

    public List<Article> getPlatinumNews() {
        return platinumNews;
    }

    public void setPlatinumNews(List<Article> platinumNews) {
        this.platinumNews = platinumNews;
    }

    public List<Article> getOilNews() {
        return oilNews;
    }

    public void setOilNews(List<Article> oilNews) {
        this.oilNews = oilNews;
    }
}