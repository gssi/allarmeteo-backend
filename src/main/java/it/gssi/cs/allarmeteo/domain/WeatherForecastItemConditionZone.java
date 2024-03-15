package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "weather_forecast_items_weather_conditions_zones")
public class WeatherForecastItemConditionZone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "weather_forecast_item_id", nullable = false)
  private WeatherForecastItem weatherForecastItem;

  @ManyToOne(optional = false)
  @JoinColumn(name = "weather_condition_id", nullable = false)
  private WeatherCondition weatherCondition;

  @ManyToOne(optional = false)
  @JoinColumn(name = "zone_id", nullable = false)
  private Zone zone;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public WeatherForecastItem getWeatherForecastItem() {
    return weatherForecastItem;
  }

  public void setWeatherForecastItem(WeatherForecastItem weatherForecastItem) {
    this.weatherForecastItem = weatherForecastItem;
  }

  public WeatherCondition getWeatherCondition() {
    return weatherCondition;
  }

  public void setWeatherCondition(WeatherCondition weatherCondition) {
    this.weatherCondition = weatherCondition;
  }

  public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }
}
