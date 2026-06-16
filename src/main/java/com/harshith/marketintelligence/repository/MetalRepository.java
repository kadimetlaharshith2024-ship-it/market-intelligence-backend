package com.harshith.marketintelligence.repository;

import com.harshith.marketintelligence.model.Metal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MetalRepository extends JpaRepository<Metal, Long> {

    Optional<Metal> findByNameIgnoreCase(String name);

    List<Metal> findByPriceBetween(double minPrice, double maxPrice);
}