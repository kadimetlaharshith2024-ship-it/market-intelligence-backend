package com.harshith.marketintelligence.repository;

import com.harshith.marketintelligence.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

}