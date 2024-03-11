package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "criticality_warning")
public class CriticalityWarning {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "criticality_warning_number", nullable = false)
  private Integer number;

  @Column(name = "criticality_warning_date", nullable = false)
  private LocalDateTime date;

  @Column(name = "criticality_warning_subject", nullable = false)
  private String subject;

  @Column(name = "header", nullable = false)
  private String header;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDateTime endDate;

  @Lob
  @Column(name = "criticality_conditions", nullable = false)
  private String criticalityConditions;

  @Column(name = "protocol", nullable = false)
  private String protocol;

  @OneToOne(optional = false, orphanRemoval = true)
  @JoinColumn(name = "map_id", nullable = false)
  private Image map;

  @ManyToOne(optional = false)
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

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public String getCriticalityConditions() {
    return criticalityConditions;
  }

  public void setCriticalityConditions(String criticalityConditions) {
    this.criticalityConditions = criticalityConditions;
  }

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public Image getMap() {
    return map;
  }

  public void setMap(Image map) {
    this.map = map;
  }

  public User getIssuer() {
    return issuer;
  }

  public void setIssuer(User issuer) {
    this.issuer = issuer;
  }

  public LocalDateTime getIssuedDate() {
    return issuedDate;
  }

  public void setIssuedDate(LocalDateTime issuedDate) {
    this.issuedDate = issuedDate;
  }
}
