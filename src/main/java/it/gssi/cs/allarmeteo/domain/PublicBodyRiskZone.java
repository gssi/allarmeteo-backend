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
@Table(name = "public_bodies_risks_zones")
public class PublicBodyRiskZone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "public_body_id", nullable = false)
  private PublicBody publicBody;

  @ManyToOne(optional = false)
  @JoinColumn(name = "risk_id", nullable = false)
  private Risk risk;

  @ManyToOne(optional = false)
  @JoinColumn(name = "zone_id", nullable = false)
  private Zone zone;

  public PublicBodyRiskZone() {}

  public PublicBodyRiskZone(PublicBody publicBody, Risk risk, Zone zone) {
    this.publicBody = publicBody;
    this.risk = risk;
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
}
