package com.harshith.marketintelligence.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {

        SimpleCacheManager manager =
                new SimpleCacheManager();

        manager.setCaches(List.of(

                new CaffeineCache(
                        "market",
                        Caffeine.newBuilder()
                                .expireAfterWrite(
                                        5,
                                        TimeUnit.MINUTES
                                )
                                .build()
                ),

                new CaffeineCache(
                        "oil",
                        Caffeine.newBuilder()
                                .expireAfterWrite(
                                        5,
                                        TimeUnit.MINUTES
                                )
                                .build()
                ),

                new CaffeineCache(
                        "weather",
                        Caffeine.newBuilder()
                                .expireAfterWrite(
                                        10,
                                        TimeUnit.MINUTES
                                )
                                .build()
                ),

                new CaffeineCache(
                        "metals",
                        Caffeine.newBuilder()
                                .expireAfterWrite(
                                        30,
                                        TimeUnit.MINUTES
                                )
                                .build()
                ),

                new CaffeineCache(
                        "news",
                        Caffeine.newBuilder()
                                .expireAfterWrite(
                                        12,
                                        TimeUnit.HOURS
                                )
                                .build()
                ),

                new CaffeineCache(
                        "rainfall",
                        Caffeine.newBuilder()
                                .expireAfterWrite(
                                        60,
                                        TimeUnit.MINUTES
                                )
                                .build()
                )

        ));

        return manager;
    }
}