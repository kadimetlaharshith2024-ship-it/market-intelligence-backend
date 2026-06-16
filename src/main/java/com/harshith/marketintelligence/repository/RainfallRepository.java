package com.harshith.marketintelligence.repository;

import com.harshith.marketintelligence.model.Rainfall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RainfallRepository extends JpaRepository<Rainfall, Long> {
}