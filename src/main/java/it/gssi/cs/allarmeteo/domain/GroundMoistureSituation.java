package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class GroundMoistureSituation {
  @ManyToOne(optional = false)
  @JoinColumn(name = "zone_id", nullable = false)
  private Zone zone;

  @Column(name = "saturation", nullable = false)
  private Boolean saturation = false;

  public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }

  public Boolean getSaturation() {
    return saturation;
  }

  public void setSaturation(Boolean saturation) {
    this.saturation = saturation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroundMoistureSituation that = (GroundMoistureSituation) o;
    return Objects.equals(zone, that.zone) && Objects.equals(saturation, that.saturation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(zone, saturation);
  }
}
