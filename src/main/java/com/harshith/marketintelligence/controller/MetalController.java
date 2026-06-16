package com.harshith.marketintelligence.controller;

import com.harshith.marketintelligence.model.Metal;
import com.harshith.marketintelligence.service.MetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController
public class MetalController {

    @Autowired
    private MetalService metalService;

    @GetMapping("/metals")
    public List<Metal> getAllMetals() {
        return metalService.getAllMetals();
    }

    @GetMapping("/metals/{name}")
    public Metal getMetal(@PathVariable String name) {
        return metalService.getMetalByName(name);
    }

    @PostMapping("/metals")
    public Metal addMetal(@RequestBody Metal metal) {
        return metalService.saveMetal(metal);
    }

    @PutMapping("/metals/{id}")
    public Metal updateMetal(@PathVariable Long id,
                             @RequestBody Metal metal) {
        return metalService.updateMetal(id, metal);
    }

    @DeleteMapping("/metals/{id}")
    public String deleteMetal(@PathVariable Long id) {
        metalService.deleteMetal(id);
        return "Metal Deleted Successfully";
    }

    @GetMapping("/metals/id/{id}")
    public Metal getMetalById(@PathVariable Long id) {
        return metalService.getMetalById(id);
    }

    @GetMapping("/metals/price/{min}/{max}")
    public List<Metal> getMetalsByPriceRange(
            @PathVariable double min,
            @PathVariable double max) {

        return metalService.getMetalsByPriceRange(min, max);
    }
}