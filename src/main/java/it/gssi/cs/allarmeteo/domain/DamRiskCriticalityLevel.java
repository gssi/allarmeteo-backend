package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "dams_risks_criticality_levels")
public class DamRiskCriticalityLevel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "zone_id", nullable = false)
  private Zone zone;

  @ManyToOne(optional = false)
  @JoinColumn(name = "risk_id", nullable = false)
  private Risk risk;

  @ManyToOne(optional = false)
  @JoinColumn(name = "criticality_level_id", nullable = false)
  private CriticalityLevel criticalityLevel;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }

  public Risk getRisk() {
    return risk;
  }

  public void setRisk(Risk risk) {
    this.risk = risk;
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
    DamRiskCriticalityLevel that = (DamRiskCriticalityLevel) o;
    return Objects.equals(id, that.id)
        && Objects.equals(zone, that.zone)
        && Objects.equals(risk, that.risk)
        && Objects.equals(criticalityLevel, that.criticalityLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, zone, risk, criticalityLevel);
  }
}
