package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class CriticalitySituationItem {
  @ManyToOne(optional = false)
  @JoinColumn(name = "risk_type_id", nullable = false)
  private RiskType riskType;

  @ManyToOne(optional = false)
  @JoinColumn(name = "zone_id")
  private Zone zone;

  @ManyToOne(optional = false)
  @JoinColumn(name = "criticality_level_id")
  private CriticalityLevel criticalityLevel;

  public RiskType getRiskType() {
    return riskType;
  }

  public void setRiskType(RiskType riskType) {
    this.riskType = riskType;
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
    return Objects.equals(riskType, that.riskType)
        && Objects.equals(zone, that.zone)
        && Objects.equals(criticalityLevel, that.criticalityLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(riskType, zone, criticalityLevel);
  }
}
