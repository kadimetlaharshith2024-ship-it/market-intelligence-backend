package com.harshith.marketintelligence.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshith.marketintelligence.dto.MarketIndexResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class MarketIndexApiService {

    @Cacheable("market")
    public List<MarketIndexResponse> getMarketData() {

        try {

            ProcessBuilder pb =
                    new ProcessBuilder(
                            "python",
                            "scripts/market.py"
                    );

            Process process = pb.start();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()
                            )
                    );

            StringBuilder json =
                    new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            ObjectMapper mapper =
                    new ObjectMapper();

            return mapper.readValue(
                    json.toString(),
                    new TypeReference<List<MarketIndexResponse>>() {}
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to fetch market data",
                    e
            );
        }
    }
}