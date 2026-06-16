package com.harshith.marketintelligence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Metal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;

    private String name;

    private double price;

    private double changePercentage;

    private double change;

    private double dayHigh;

    private double dayLow;

    private double yearHigh;

    private double yearLow;

    private double open;

    private double previousClose;

    private long volume;

    private String timestamp;

    public Metal() {
    }

    public Metal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getChangePercentage() {
        return changePercentage;
    }

    public double getChange() {
        return change;
    }

    public double getDayHigh() {
        return dayHigh;
    }

    public double getDayLow() {
        return dayLow;
    }

    public double getYearHigh() {
        return yearHigh;
    }

    public double getYearLow() {
        return yearLow;
    }

    public double getOpen() {
        return open;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public long getVolume() {
        return volume;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setChangePercentage(double changePercentage) {
        this.changePercentage = changePercentage;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public void setDayHigh(double dayHigh) {
        this.dayHigh = dayHigh;
    }

    public void setDayLow(double dayLow) {
        this.dayLow = dayLow;
    }

    public void setYearHigh(double yearHigh) {
        this.yearHigh = yearHigh;
    }

    public void setYearLow(double yearLow) {
        this.yearLow = yearLow;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}