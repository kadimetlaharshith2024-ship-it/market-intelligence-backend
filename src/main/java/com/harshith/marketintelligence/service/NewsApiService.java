package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.model.Article;
import com.harshith.marketintelligence.model.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${news.api.key}")
    private String apiKey;

    @Cacheable(value = "news", key = "'gold'")
    public List<Article> getGoldNews() {

        try {

            String url =
                    "https://newsapi.org/v2/everything?q=\"gold price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                            + apiKey;

            NewsResponse response =
                    restTemplate.getForObject(url, NewsResponse.class);

            if (response == null || response.getArticles() == null) {
                return List.of();
            }

            return response.getArticles()
                    .stream()
                    .filter(article ->
                            article.getTitle() != null &&
                                    article.getTitle().toLowerCase().contains("gold"))
                    .limit(3)
                    .toList();

        } catch (RestClientException e) {

            System.out.println("Gold News API unavailable.");

            return List.of();
        }
    }

    @Cacheable(value = "news", key = "'silver'")
    public List<Article> getSilverNews() {

        try {

            String url =
                    "https://newsapi.org/v2/everything?q=\"silver price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                            + apiKey;

            NewsResponse response =
                    restTemplate.getForObject(url, NewsResponse.class);

            if (response == null || response.getArticles() == null) {
                return List.of();
            }

            return response.getArticles()
                    .stream()
                    .filter(article ->
                            article.getTitle() != null &&
                                    article.getTitle().toLowerCase().contains("silver"))
                    .limit(3)
                    .toList();

        } catch (RestClientException e) {

            System.out.println("Silver News API unavailable.");

            return List.of();
        }
    }

    @Cacheable(value = "news", key = "'copper'")
    public List<Article> getCopperNews() {

        try {

            String url =
                    "https://newsapi.org/v2/everything?q=\"copper price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                            + apiKey;

            NewsResponse response =
                    restTemplate.getForObject(url, NewsResponse.class);

            if (response == null || response.getArticles() == null) {
                return List.of();
            }

            return response.getArticles()
                    .stream()
                    .filter(article ->
                            article.getTitle() != null &&
                                    article.getTitle().toLowerCase().contains("copper"))
                    .limit(3)
                    .toList();

        } catch (RestClientException e) {

            System.out.println("Copper News API unavailable.");

            return List.of();
        }
    }
    @Cacheable(value = "news", key = "'aluminum'")
    public List<Article> getAluminumNews() {

        try {

            String url =
                    "https://newsapi.org/v2/everything?q=%22aluminium%22%20OR%20%22aluminum%22&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                            + apiKey;

            NewsResponse response =
                    restTemplate.getForObject(url, NewsResponse.class);

            if (response == null || response.getArticles() == null) {
                return List.of();
            }

            return response.getArticles()
                    .stream()
                    .filter(article ->
                            article.getTitle() != null &&
                                    (
                                            article.getTitle().toLowerCase().contains("aluminum") ||
                                                    article.getTitle().toLowerCase().contains("aluminium")
                                    ))
                    .limit(3)
                    .toList();

        } catch (RestClientException e) {

            System.out.println("Aluminum News API unavailable.");

            return List.of();
        }
    }

    @Cacheable(value = "news", key = "'platinum'")
    public List<Article> getPlatinumNews() {

        try {

            String url =
                    "https://newsapi.org/v2/everything?q=\"platinum price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                            + apiKey;

            NewsResponse response =
                    restTemplate.getForObject(url, NewsResponse.class);

            if (response == null || response.getArticles() == null) {
                return List.of();
            }

            return response.getArticles()
                    .stream()
                    .filter(article ->
                            article.getTitle() != null &&
                                    article.getTitle().toLowerCase().contains("platinum"))
                    .limit(3)
                    .toList();

        } catch (RestClientException e) {

            System.out.println("Platinum News API unavailable.");

            return List.of();
        }
    }

    @Cacheable(value = "news", key = "'oil'")
    public List<Article> getOilNews() {

        try {

            String url =
                    "https://newsapi.org/v2/everything?q=\"oil price\"&sortBy=publishedAt&pageSize=10&language=en&apiKey="
                            + apiKey;

            NewsResponse response =
                    restTemplate.getForObject(url, NewsResponse.class);

            if (response == null || response.getArticles() == null) {
                return List.of();
            }

            return response.getArticles()
                    .stream()
                    .filter(article ->
                            article.getTitle() != null &&
                                    article.getTitle().toLowerCase().contains("oil"))
                    .limit(3)
                    .toList();

        } catch (RestClientException e) {

            System.out.println("Oil News API unavailable.");

            return List.of();
        }
    }

}