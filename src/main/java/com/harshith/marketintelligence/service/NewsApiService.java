package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.model.Article;
import com.harshith.marketintelligence.model.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${news.api.key}")
    private String apiKey;

    public List<Article> getGoldNews() {

        String url =
                "https://newsapi.org/v2/everything?q=\"gold price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                        + apiKey;

        NewsResponse response =
                restTemplate.getForObject(url, NewsResponse.class);

        return response.getArticles()
                .stream()
                .filter(article ->
                        article.getTitle() != null &&
                                article.getTitle().toLowerCase().contains("gold"))
                .limit(3)
                .toList();
    }

    public List<Article> getSilverNews() {

        String url =
                "https://newsapi.org/v2/everything?q=\"silver price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                        + apiKey;

        NewsResponse response =
                restTemplate.getForObject(url, NewsResponse.class);

        return response.getArticles()
                .stream()
                .filter(article ->
                        article.getTitle() != null &&
                                article.getTitle().toLowerCase().contains("silver"))
                .limit(3)
                .toList();
    }

    public List<Article> getCopperNews() {

        String url =
                "https://newsapi.org/v2/everything?q=\"copper price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                        + apiKey;

        NewsResponse response =
                restTemplate.getForObject(url, NewsResponse.class);

        return response.getArticles()
                .stream()
                .filter(article ->
                        article.getTitle() != null &&
                                article.getTitle().toLowerCase().contains("copper"))
                .limit(3)
                .toList();
    }

    public List<Article> getAluminumNews() {

        String url =
                "https://newsapi.org/v2/everything?q=\"aluminum price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                        + apiKey;

        NewsResponse response =
                restTemplate.getForObject(url, NewsResponse.class);

        return response.getArticles()
                .stream()
                .filter(article ->
                        article.getTitle() != null &&
                                article.getTitle().toLowerCase().contains("aluminum"))
                .limit(3)
                .toList();
    }

    public List<Article> getPlatinumNews() {

        String url =
                "https://newsapi.org/v2/everything?q=\"platinum price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                        + apiKey;

        NewsResponse response =
                restTemplate.getForObject(url, NewsResponse.class);

        return response.getArticles()
                .stream()
                .filter(article ->
                        article.getTitle() != null &&
                                article.getTitle().toLowerCase().contains("platinum"))
                .limit(3)
                .toList();
    }

    public List<Article> getOilNews() {

        String url =
                "https://newsapi.org/v2/everything?q=\"oil price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                        + apiKey;

        NewsResponse response =
                restTemplate.getForObject(url, NewsResponse.class);

        return response.getArticles()
                .stream()
                .filter(article ->
                        article.getTitle() != null &&
                                article.getTitle().toLowerCase().contains("oil"))
                .limit(3)
                .toList();
    }
}