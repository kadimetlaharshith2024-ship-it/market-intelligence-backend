package com.harshith.marketintelligence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rainfall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String date;

    private String season;

    private double temperature;

    private double humidity;

    private double pressure;

    private double windSpeed;

    private double cloudCover;

    private double rainfallYesterday;

    private double rainfallAmount;

    public Rainfall() {
    }

    public Rainfall(String city, String date, String season,
                    double temperature, double humidity,
                    double pressure, double windSpeed,
                    double cloudCover, double rainfallYesterday,
                    double rainfallAmount) {

        this.city = city;
        this.date = date;
        this.season = season;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.cloudCover = cloudCover;
        this.rainfallYesterday = rainfallYesterday;
        this.rainfallAmount = rainfallAmount;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public String getSeason() {
        return season;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public double getRainfallYesterday() {
        return rainfallYesterday;
    }

    public double getRainfallAmount() {
        return rainfallAmount;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public void setRainfallYesterday(double rainfallYesterday) {
        this.rainfallYesterday = rainfallYesterday;
    }

    public void setRainfallAmount(double rainfallAmount) {
        this.rainfallAmount = rainfallAmount;
    }
}