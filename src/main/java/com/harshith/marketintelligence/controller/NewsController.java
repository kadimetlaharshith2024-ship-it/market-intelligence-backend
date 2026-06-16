package com.harshith.marketintelligence.controller;

import com.harshith.marketintelligence.model.News;
import com.harshith.marketintelligence.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @PostMapping("/news")
    public News addNews(@RequestBody News news) {
        return newsService.saveNews(news);
    }
}