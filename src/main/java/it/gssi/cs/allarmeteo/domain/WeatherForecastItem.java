package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "weather_forecast_items")
public class WeatherForecastItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "weather_forecast_item_date", nullable = false)
  private LocalDateTime date;

  @Column(name = "precipitations", nullable = false)
  private String precipitations;

  @Column(name = "visibility", nullable = false)
  private String visibility;

  @Column(name = "temperatures", nullable = false)
  private String temperatures;

  @Column(name = "winds", nullable = false)
  private String winds;

  @Column(name = "seas", nullable = false)
  private String seas;

  @OneToMany(mappedBy = "weatherForecastItem", orphanRemoval = true)
  private Set<WeatherForecastItemConditionZone> weatherForecastItemConditionZones = new HashSet<>();

  @OneToOne(orphanRemoval = true)
  @JoinColumn(name = "image_id")
  private Image map;

  @ManyToOne
  @JoinColumn(name = "weather_forecast_id")
  private WeatherForecast weatherForecast;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public String getVisibility() {
    return visibility;
  }

  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  public String getTemperatures() {
    return temperatures;
  }

  public void setTemperatures(String temperatures) {
    this.temperatures = temperatures;
  }

  public String getWinds() {
    return winds;
  }

  public void setWinds(String winds) {
    this.winds = winds;
  }

  public String getSeas() {
    return seas;
  }

  public void setSeas(String seas) {
    this.seas = seas;
  }

  public Set<WeatherForecastItemConditionZone> getWeatherForecastItemConditionZones() {
    return weatherForecastItemConditionZones;
  }

  public void setWeatherForecastItemConditionZones(
      Set<WeatherForecastItemConditionZone> weatherForecastItemConditionZones) {
    this.weatherForecastItemConditionZones = weatherForecastItemConditionZones;
  }

  public Image getMap() {
    return map;
  }

  public void setMap(Image map) {
    this.map = map;
  }

  public WeatherForecast getWeatherForecast() {
    return weatherForecast;
  }

  public void setWeatherForecast(WeatherForecast weatherForecast) {
    this.weatherForecast = weatherForecast;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WeatherForecastItem that = (WeatherForecastItem) o;
    return Objects.equals(id, that.id)
        && Objects.equals(date, that.date)
        && Objects.equals(precipitations, that.precipitations)
        && Objects.equals(visibility, that.visibility)
        && Objects.equals(temperatures, that.temperatures)
        && Objects.equals(winds, that.winds)
        && Objects.equals(seas, that.seas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, precipitations, visibility, temperatures, winds, seas);
  }
}
