package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "reports")
public class Report {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "report_date", nullable = false)
  private LocalDateTime date;

  @Lob
  @Column(name = "report_description", nullable = false)
  private String description;

  @ManyToOne(optional = false)
  @JoinColumn(name = "public_body_id", nullable = false)
  private PublicBody publicBody;

  @ManyToOne
  @JoinColumn(name = "zone_id", unique = true)
  private Zone zone;

  @ManyToOne(optional = false)
  @JoinColumn(name = "risk_id", nullable = false)
  private Risk risk;

  @ManyToOne
  @JoinColumn(name = "criticality_evaluation_id")
  private CriticalityEvaluation criticalityEvaluation;

  public Report() {}

  public Report(
      LocalDateTime date, String description, PublicBody publicBody, Zone zone, Risk risk) {
    this.date = date;
    this.description = description;
    this.publicBody = publicBody;
    this.zone = zone;
    this.risk = risk;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PublicBody getPublicBody() {
    return publicBody;
  }

  public void setPublicBody(PublicBody publicBody) {
    this.publicBody = publicBody;
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

  public CriticalityEvaluation getCriticalityEvaluation() {
    return criticalityEvaluation;
  }

  public void setCriticalityEvaluation(CriticalityEvaluation criticalityEvaluation) {
    this.criticalityEvaluation = criticalityEvaluation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Report report = (Report) o;
    return Objects.equals(id, report.id)
        && Objects.equals(date, report.date)
        && Objects.equals(description, report.description)
        && Objects.equals(publicBody, report.publicBody)
        && Objects.equals(zone, report.zone)
        && Objects.equals(risk, report.risk);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, description, publicBody, zone, risk);
  }
}
