package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class FireForecast {
    @Column(name = "forecast_date", nullable = false)
    private LocalDateTime date;

    @Column(name = "forecast_precipitations", nullable = false)
    private String precipitations;

    @Column(name = "forecast_winds", nullable = false)
    private String winds;

    @Column(name = "forecast_temperatures", nullable = false)
    private String temperatures;

    @Column(name = "forecast_low_layers_minimum_humidity", nullable = false)
    private String lowLayersMinimumHumidity;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPrecipitations() {
        return precipitations;
    }

    public void setPrecipitations(String precipitations) {
        this.precipitations = precipitations;
    }

    public String getWinds() {
        return winds;
    }

    public void setWinds(String winds) {
        this.winds = winds;
    }

    public String getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(String temperatures) {
        this.temperatures = temperatures;
    }

    public String getLowLayersMinimumHumidity() {
        return lowLayersMinimumHumidity;
    }

    public void setLowLayersMinimumHumidity(String lowLayersMinimumHumidity) {
        this.lowLayersMinimumHumidity = lowLayersMinimumHumidity;
    }
}