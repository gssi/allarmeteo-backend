package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.*;

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

  @OneToOne(optional = false, orphanRemoval = true)
  @JoinColumn(name = "issuer_id", nullable = false)
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

  public void addReport(Report report) {
    this.reports.add(report);
  }

  public void removeReport(Report report) {
    this.reports.remove(report);
  }

  public Set<Precipitation> getPrecipitations() {
    return precipitations;
  }

  public void setPrecipitations(Set<Precipitation> precipitations) {
    this.precipitations = precipitations;
  }

  public void addPrecipitation(Precipitation precipitation) {
    this.precipitations.add(precipitation);
  }

  public void removePrecipitation(Precipitation precipitation) {
    this.precipitations.remove(precipitation);
  }

  public Set<GroundSnowSituation> getGroundSnowSituations() {
    return groundSnowSituations;
  }

  public void setGroundSnowSituations(Set<GroundSnowSituation> groundSnowSituations) {
    this.groundSnowSituations = groundSnowSituations;
  }

  public void addGroundSnowSituation(GroundSnowSituation groundSnowSituation) {
    this.groundSnowSituations.add(groundSnowSituation);
  }

  public void removeGroundSnowSituation(GroundSnowSituation groundSnowSituation) {
    this.groundSnowSituations.remove(groundSnowSituation);
  }

  public Set<SignificantTemperatureVariation> getSignificantTemperatureVariations() {
    return significantTemperatureVariations;
  }

  public void setSignificantTemperatureVariations(
      Set<SignificantTemperatureVariation> significantTemperatureVariations) {
    this.significantTemperatureVariations = significantTemperatureVariations;
  }

  public void addSignificantTemperatureVariation(
      SignificantTemperatureVariation significantTemperatureVariation) {
    this.significantTemperatureVariations.add(significantTemperatureVariation);
  }

  public void removeSignificantTemperatureVariation(
      SignificantTemperatureVariation significantTemperatureVariation) {
    this.significantTemperatureVariations.remove(significantTemperatureVariation);
  }

  public Set<CriticalitySituation> getCriticalitySituations() {
    return criticalitySituations;
  }

  public void setCriticalitySituations(Set<CriticalitySituation> criticalitySituations) {
    this.criticalitySituations = criticalitySituations;
  }

  public void addCriticalitySituation(CriticalitySituation criticalitySituation) {
    this.criticalitySituations.add(criticalitySituation);
  }

  public void removeCriticalitySituation(CriticalitySituation criticalitySituation) {
    this.criticalitySituations.remove(criticalitySituation);
  }

  public Set<User> getCompilers() {
    return compilers;
  }

  public void setCompilers(Set<User> compilers) {
    this.compilers = compilers;
  }

  public void addCompiler(User user) {
    this.compilers.add(user);
  }

  public void removeCompiler(User user) {
    this.compilers.remove(user);
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
