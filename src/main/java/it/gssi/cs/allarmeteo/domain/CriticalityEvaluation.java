package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "criticality_evaluations")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CriticalityEvaluation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToMany(mappedBy = "criticalityEvaluation")
  private Set<Report> reports = new HashSet<>();

  @ElementCollection
  @CollectionTable(
      name = "criticality_evaluations_precipitations",
      joinColumns = @JoinColumn(name = "criticality_evaluation_id"))
  private Set<Precipitation> precipitations = new HashSet<>();

  @ElementCollection
  @CollectionTable(
      name = "criticality_evaluations_ground_snow_situations",
      joinColumns = @JoinColumn(name = "criticality_evaluation_id"))
  private Set<GroundSnowSituation> groundSnowSituations = new HashSet<>();

  @ElementCollection
  @CollectionTable(
      name = "criticality_evaluations_significant_temperature_variations",
      joinColumns = @JoinColumn(name = "criticality_evaluation_id"))
  private Set<SignificantTemperatureVariation> significantTemperatureVariations = new HashSet<>();

  @OneToMany(mappedBy = "criticalityEvaluation")
  private Set<CriticalitySituation> criticalitySituations = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "criticality_evaluation_compilers",
      joinColumns = @JoinColumn(name = "criticality_evaluation_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> compilers = new HashSet<>();

  @Column(name = "compliance", nullable = false)
  private Boolean compliance = false;

  @Lob
  @Column(name = "noncompliance_reason")
  private String noncomplianceReason;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User issuer;

  @Column(name = "issued_date", nullable = false)
  private LocalDateTime issuedDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<Report> getReports() {
    return reports;
  }

  public void setReports(Set<Report> reports) {
    this.reports = reports;
  }

  public Set<Precipitation> getPrecipitations() {
    return precipitations;
  }

  public void setPrecipitations(Set<Precipitation> precipitations) {
    this.precipitations = precipitations;
  }

  public Set<GroundSnowSituation> getGroundSnowSituations() {
    return groundSnowSituations;
  }

  public void setGroundSnowSituations(Set<GroundSnowSituation> groundSnowSituations) {
    this.groundSnowSituations = groundSnowSituations;
  }

  public Set<SignificantTemperatureVariation> getSignificantTemperatureVariations() {
    return significantTemperatureVariations;
  }

  public void setSignificantTemperatureVariations(
      Set<SignificantTemperatureVariation> significantTemperatureVariations) {
    this.significantTemperatureVariations = significantTemperatureVariations;
  }

  public Set<CriticalitySituation> getCriticalitySituations() {
    return criticalitySituations;
  }

  public void setCriticalitySituations(Set<CriticalitySituation> criticalitySituations) {
    this.criticalitySituations = criticalitySituations;
  }

  public Set<User> getCompilers() {
    return compilers;
  }

  public void setCompilers(Set<User> compilers) {
    this.compilers = compilers;
  }

  public Boolean getCompliance() {
    return compliance;
  }

  public void setCompliance(Boolean compliance) {
    this.compliance = compliance;
  }

  public String getNoncomplianceReason() {
    return noncomplianceReason;
  }

  public void setNoncomplianceReason(String noncomplianceReason) {
    this.noncomplianceReason = noncomplianceReason;
  }

  public LocalDateTime getIssuedDate() {
    return issuedDate;
  }

  public void setIssuedDate(LocalDateTime issuedDate) {
    this.issuedDate = issuedDate;
  }

  public User getIssuer() {
    return issuer;
  }

  public void setIssuer(User issuer) {
    this.issuer = issuer;
  }
}
