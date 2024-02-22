package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class Precipitation {

  @ManyToOne
  @JoinColumn(name = "zone_id")
  private Zone zone;

  @Enumerated(EnumType.STRING)
  @Column(name = "precipitation_phase", nullable = false)
  private PrecipitationPhase precipitationPhase;

  @Column(name = "precipitation_value", nullable = false)
  private Integer value;

  public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }

  public PrecipitationPhase getPrecipitationPhase() {
    return precipitationPhase;
  }

  public void setPrecipitationPhase(PrecipitationPhase precipitationPhase) {
    this.precipitationPhase = precipitationPhase;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Precipitation that = (Precipitation) o;
    return Objects.equals(zone, that.zone)
        && precipitationPhase == that.precipitationPhase
        && Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(zone, precipitationPhase, value);
  }
}
