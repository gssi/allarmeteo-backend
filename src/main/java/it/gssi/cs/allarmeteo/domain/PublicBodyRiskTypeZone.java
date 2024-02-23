package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "public_bodies_risk_type_zones")
public class PublicBodyRiskTypeZone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "public_body_id", nullable = false)
  private PublicBody publicBody;

  @ManyToOne(optional = false)
  @JoinColumn(name = "risk_type_id", nullable = false)
  private RiskType riskType;

  @ManyToOne(optional = false)
  @JoinColumn(name = "zone_id", nullable = false)
  private Zone zone;

  public PublicBodyRiskTypeZone() {}

  public PublicBodyRiskTypeZone(PublicBody publicBody, RiskType riskType, Zone zone) {
    this.publicBody = publicBody;
    this.riskType = riskType;
    this.zone = zone;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PublicBody getPublicBody() {
    return publicBody;
  }

  public void setPublicBody(PublicBody publicBody) {
    this.publicBody = publicBody;
  }

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
}
