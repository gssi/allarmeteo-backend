package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Objects;

@Embeddable
public class SignificantTemperatureVariation {
  @OneToOne(optional = false)
  @JoinColumn(name = "zone_id", nullable = false)
  private Zone zone;

  @Column(name = "significant_increase", nullable = false)
  private Boolean significantIncrease = false;

  public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }

  public Boolean getSignificantIncrease() {
    return significantIncrease;
  }

  public void setSignificantIncrease(Boolean significantIncrease) {
    this.significantIncrease = significantIncrease;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SignificantTemperatureVariation that = (SignificantTemperatureVariation) o;
    return Objects.equals(zone, that.zone)
        && Objects.equals(significantIncrease, that.significantIncrease);
  }

  @Override
  public int hashCode() {
    return Objects.hash(zone, significantIncrease);
  }
}
