package com.harshith.marketintelligence.service;

import com.harshith.marketintelligence.model.Rainfall;
import com.harshith.marketintelligence.model.WeatherResponse;
import com.harshith.marketintelligence.repository.RainfallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harshith.marketintelligence.dto.RainfallPredictionResponse;
import org.springframework.cache.annotation.Cacheable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

@Service
public class RainfallService {

    @Autowired
    private RainfallRepository rainfallRepository;

    @Autowired
    private WeatherService weatherService;

    public List<Rainfall> getAllRainfallData() {
        return rainfallRepository.findAll();
    }

    public Rainfall saveRainfall(Rainfall rainfall) {
        return rainfallRepository.save(rainfall);
    }

    public String predictRainfall() {

        try {

            WeatherResponse weather =
                    weatherService.getMumbaiWeather();

            double temperature =
                    weather.getMain().getTemp();

            double humidity =
                    weather.getMain().getHumidity();

            double pressure =
                    weather.getMain().getPressure();

            double windSpeed =
                    weather.getWind().getSpeed();

            double cloudCover =
                    weather.getClouds().getAll();

            int visibility =
                    weather.getVisibility();

            int month =
                    LocalDate.now().getMonthValue();

            ProcessBuilder processBuilder =
                    new ProcessBuilder(
                            "python",
                            "scripts/rainfall_predict.py",
                            String.valueOf(temperature),
                            String.valueOf(humidity),
                            String.valueOf(pressure),
                            String.valueOf(windSpeed),
                            String.valueOf(cloudCover),
                            String.valueOf(visibility),
                            String.valueOf(month)
                    );

            Process process =
                    processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()
                            )
                    );

            return reader.readLine();

        } catch (Exception e) {

            e.printStackTrace();

            return "Prediction Failed";
        }
    }

    @Cacheable("rainfall")
    public RainfallPredictionResponse getPredictionReport() {

        try {

            WeatherResponse weather =
                    weatherService.getMumbaiWeather();

            double temperature =
                    weather.getMain().getTemp();

            double humidity =
                    weather.getMain().getHumidity();

            double pressure =
                    weather.getMain().getPressure();

            double windSpeed =
                    weather.getWind().getSpeed();

            double cloudCover =
                    weather.getClouds().getAll();

            int visibility =
                    weather.getVisibility();

            int month =
                    java.time.LocalDate.now()
                            .getMonthValue();

            ProcessBuilder processBuilder =
                    new ProcessBuilder(
                            "python",
                            "scripts/rainfall_predict.py",
                            String.valueOf(temperature),
                            String.valueOf(humidity),
                            String.valueOf(pressure),
                            String.valueOf(windSpeed),
                            String.valueOf(cloudCover),
                            String.valueOf(visibility),
                            String.valueOf(month)
                    );

            Process process =
                    processBuilder.start();

            java.io.BufferedReader reader =
                    new java.io.BufferedReader(
                            new java.io.InputStreamReader(
                                    process.getInputStream()
                            )
                    );

            String prediction =
                    reader.readLine();

            RainfallPredictionResponse response =
                    new RainfallPredictionResponse();

            response.setCity("Mumbai");
            response.setTemperature(temperature);
            response.setHumidity(humidity);
            response.setPressure(pressure);
            response.setWindSpeed(windSpeed);
            response.setCloudCover(cloudCover);
            response.setVisibility(visibility);
            response.setPrediction(prediction);

            return response;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}