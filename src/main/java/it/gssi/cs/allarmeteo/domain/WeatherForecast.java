package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "weather_forecasts")
public class WeatherForecast {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDateTime endDate;

  @Column(name = "situation", nullable = false)
  private String situation;

  @Column(name = "weekend_trend")
  private String weekendTrend;

  @OneToMany(mappedBy = "weatherForecast", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<WeatherForecastItem> weatherForecastItems = new HashSet<>();

  @Enumerated(EnumType.STRING)
  @Column(name = "state", nullable = false)
  private DocumentState state;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public String getSituation() {
    return situation;
  }

  public void setSituation(String situation) {
    this.situation = situation;
  }

  public String getWeekendTrend() {
    return weekendTrend;
  }

  public void setWeekendTrend(String weekendTrend) {
    this.weekendTrend = weekendTrend;
  }

  public Set<WeatherForecastItem> getWeatherForecastItems() {
    return weatherForecastItems;
  }

  public void setWeatherForecastItems(Set<WeatherForecastItem> weatherForecastItems) {
    this.weatherForecastItems = weatherForecastItems;
  }

  public DocumentState getState() {
    return state;
  }

  public void setState(DocumentState state) {
    this.state = state;
  }
}
