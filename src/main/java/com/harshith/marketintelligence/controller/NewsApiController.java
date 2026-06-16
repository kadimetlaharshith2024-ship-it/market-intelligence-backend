package com.harshith.marketintelligence.controller;

import com.harshith.marketintelligence.model.Article;
import com.harshith.marketintelligence.service.NewsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsApiController {

    @Autowired
    private NewsApiService newsApiService;

    @GetMapping("/news/gold")
    public List<Article> getGoldNews() {
        return newsApiService.getGoldNews();
    }

    @GetMapping("/news/silver")
    public List<Article> getSilverNews() {
        return newsApiService.getSilverNews();
    }

    @GetMapping("/news/copper")
    public List<Article> getCopperNews() {
        return newsApiService.getCopperNews();
    }

    @GetMapping("/news/aluminum")
    public List<Article> getAluminumNews() {
        return newsApiService.getAluminumNews();
    }

    @GetMapping("/news/platinum")
    public List<Article> getPlatinumNews() {
        return newsApiService.getPlatinumNews();
    }

    @GetMapping("/news/oil")
    public List<Article> getOilNews() {
        return newsApiService.getOilNews();
    }
}