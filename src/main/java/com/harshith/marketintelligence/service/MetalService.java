package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.model.Metal;
import com.harshith.marketintelligence.repository.MetalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetalService {

    @Autowired
    private MetalRepository metalRepository;

    public List<Metal> getAllMetals() {
        return metalRepository.findAll();
    }

    public Metal getMetalByName(String name) {

        Metal metal = metalRepository
                .findByNameIgnoreCase(name)
                .orElse(null);

        if (metal == null) {
            Metal notFound = new Metal();
            notFound.setName("Not Found");
            notFound.setPrice(0);
            return notFound;
        }

        return metal;
    }

    public Metal saveMetal(Metal metal) {
        return metalRepository.save(metal);
    }

    public Metal updateMetal(Long id, Metal updatedMetal) {

        Metal metal = metalRepository.findById(id).orElse(null);

        if (metal == null) {
            return null;
        }

        metal.setName(updatedMetal.getName());
        metal.setPrice(updatedMetal.getPrice());

        return metalRepository.save(metal);
    }

    public void deleteMetal(Long id) {
        metalRepository.deleteById(id);
    }

    public Metal getMetalById(Long id) {
        return metalRepository.findById(id).orElse(null);
    }

    public List<Metal> getMetalsByPriceRange(double minPrice, double maxPrice) {
        return metalRepository.findByPriceBetween(minPrice, maxPrice);
    }
}