package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class CriticalitySituationItem {
  @ManyToOne(optional = false)
  @JoinColumn(name = "risk_id", nullable = false)
  private Risk risk;

  @ManyToOne(optional = false)
  @JoinColumn(name = "zone_id")
  private Zone zone;

  @ManyToOne(optional = false)
  @JoinColumn(name = "criticality_level_id")
  private CriticalityLevel criticalityLevel;

  public Risk getRisk() {
    return risk;
  }

  public void setRisk(Risk risk) {
    this.risk = risk;
  }

  public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }

  public CriticalityLevel getCriticalityLevel() {
    return criticalityLevel;
  }

  public void setCriticalityLevel(CriticalityLevel criticalityLevel) {
    this.criticalityLevel = criticalityLevel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CriticalitySituationItem that = (CriticalitySituationItem) o;
    return Objects.equals(risk, that.risk)
        && Objects.equals(zone, that.zone)
        && Objects.equals(criticalityLevel, that.criticalityLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(risk, zone, criticalityLevel);
  }
}
