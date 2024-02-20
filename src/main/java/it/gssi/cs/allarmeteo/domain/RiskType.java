package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "risk_types")
public class RiskType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Lob
  @Column(name = "description", nullable = false)
  private String description;

  @ManyToMany(mappedBy = "riskTypes")
  private Set<Zone> zones = new HashSet<>();

  @OneToMany(mappedBy = "riskType", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<RiskTypeCriticalityLevel> criticalityLevels = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<Zone> getZones() {
    return zones;
  }

  public void setZones(Set<Zone> zones) {
    this.zones = zones;
  }

  public void addZone(Zone zone) {
    this.zones.add(zone);
  }

  public void removeZone(Zone zone) {
    this.zones.remove(zone);
  }

  public Set<RiskTypeCriticalityLevel> getCriticalityLevels() {
    return criticalityLevels;
  }

  public void setCriticalityLevels(Set<RiskTypeCriticalityLevel> criticalityLevels) {
    this.criticalityLevels = criticalityLevels;
  }

  public void addCriticalityLevel(CriticalityLevel criticalityLevel) {
    RiskTypeCriticalityLevel riskTypeCriticalityLevel =
        new RiskTypeCriticalityLevel(this, criticalityLevel);
    this.criticalityLevels.add(riskTypeCriticalityLevel);
  }

  public void removeCriticalityLevel(CriticalityLevel criticalityLevel) {
    for (RiskTypeCriticalityLevel riskTypeCriticalityLevel : this.criticalityLevels) {
      if (riskTypeCriticalityLevel.getRiskType().equals(this)
          && riskTypeCriticalityLevel.getCriticalityLevel().equals(criticalityLevel)) {
        this.criticalityLevels.remove(riskTypeCriticalityLevel);
        riskTypeCriticalityLevel.setRiskType(null);
        riskTypeCriticalityLevel.setCriticalityLevel(null);
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RiskType riskType = (RiskType) o;
    return Objects.equals(id, riskType.id)
        && Objects.equals(name, riskType.name)
        && Objects.equals(description, riskType.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description);
  }
}
