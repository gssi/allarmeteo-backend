package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "zones")
public class Zone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Lob
  @Column(name = "zone_description", nullable = false)
  private String description;

  @Column(name = "weather_surveillance_number")
  private Integer weatherSurveillanceNumber;

  @Column(name = "is_dam", nullable = false)
  private Boolean isDam = false;

  @ManyToMany
  @JoinTable(
      name = "zones_provinces",
      joinColumns = @JoinColumn(name = "zone_id"),
      inverseJoinColumns = @JoinColumn(name = "province_id"))
  private Set<Province> provinces = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "zones_risks",
      joinColumns = @JoinColumn(name = "zone_id"),
      inverseJoinColumns = @JoinColumn(name = "risk_id"))
  private Set<Risk> risks = new HashSet<>();

  @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Report> reports = new HashSet<>();

  @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<DamRiskCriticalityLevel> damRiskCriticalityLevels = new HashSet<>();

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

  public Integer getWeatherSurveillanceNumber() {
    return weatherSurveillanceNumber;
  }

  public void setWeatherSurveillanceNumber(Integer weatherSurveillanceNumber) {
    this.weatherSurveillanceNumber = weatherSurveillanceNumber;
  }

  public Boolean getIsDam() {
    return isDam;
  }

  public void setIsDam(Boolean isDam) {
    this.isDam = isDam;
  }

  public Set<Province> getProvinces() {
    return provinces;
  }

  public void setProvinces(Set<Province> provinces) {
    this.provinces = provinces;
  }

  public Set<Risk> getRisks() {
    return risks;
  }

  public void setRisks(Set<Risk> risks) {
    this.risks = risks;
  }

  public Set<Report> getReports() {
    return reports;
  }

  public void setReports(Set<Report> reports) {
    this.reports = reports;
  }

  public Set<DamRiskCriticalityLevel> getDamRiskCriticalityLevels() {
    return damRiskCriticalityLevels;
  }

  public void setDamRiskCriticalityLevels(Set<DamRiskCriticalityLevel> damRiskCriticalityLevels) {
    this.damRiskCriticalityLevels = damRiskCriticalityLevels;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Zone zone = (Zone) o;
    return Objects.equals(id, zone.id)
        && Objects.equals(name, zone.name)
        && Objects.equals(description, zone.description)
        && Objects.equals(isDam, zone.isDam);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, isDam);
  }
}
