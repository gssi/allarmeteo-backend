package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "operational_phase_declaration_items")
public class OperationalPhaseDeclarationItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", unique = false)
  private LocalDateTime endDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
  private OperationalPhaseType type;

  @Enumerated(EnumType.STRING)
  @Column(name = "operational_phase_alert_type", nullable = false)
  private OperationalPhaseAlertType alertType;

  @ManyToMany
  @JoinTable(
      name = "operational_phase_declaration_items_zones",
      joinColumns = @JoinColumn(name = "operational_phase_declaration_item_id"),
      inverseJoinColumns = @JoinColumn(name = "zones_id"))
  private Set<Zone> zones = new HashSet<>();

  @ManyToOne(optional = false)
  @JoinColumn(name = "criticality_bulletin_id", nullable = false)
  private CriticalityBulletin criticalityBulletin;

  @Column(name = "termination_declaration", nullable = false)
  private Boolean isTerminationDeclaration = false;

  @OneToOne
  @JoinColumn(name = "source_criticality_bulletin_id")
  private CriticalityBulletin sourceCriticalityBulletin;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public OperationalPhaseType getType() {
    return type;
  }

  public void setType(OperationalPhaseType type) {
    this.type = type;
  }

  public OperationalPhaseAlertType getAlertType() {
    return alertType;
  }

  public void setAlertType(OperationalPhaseAlertType alertType) {
    this.alertType = alertType;
  }

  public Set<Zone> getZones() {
    return zones;
  }

  public void setZones(Set<Zone> zones) {
    this.zones = zones;
  }

  public CriticalityBulletin getCriticalityBulletin() {
    return criticalityBulletin;
  }

  public void setCriticalityBulletin(CriticalityBulletin criticalityBulletin) {
    this.criticalityBulletin = criticalityBulletin;
  }

  public Boolean getTerminationDeclaration() {
    return isTerminationDeclaration;
  }

  public void setTerminationDeclaration(Boolean terminationDeclaration) {
    isTerminationDeclaration = terminationDeclaration;
  }

  public CriticalityBulletin getSourceCriticalityBulletin() {
    return sourceCriticalityBulletin;
  }

  public void setSourceCriticalityBulletin(CriticalityBulletin sourceCriticalityBulletin) {
    this.sourceCriticalityBulletin = sourceCriticalityBulletin;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OperationalPhaseDeclarationItem that = (OperationalPhaseDeclarationItem) o;
    return Objects.equals(id, that.id)
        && Objects.equals(startDate, that.startDate)
        && Objects.equals(endDate, that.endDate)
        && type == that.type
        && alertType == that.alertType
        && Objects.equals(zones, that.zones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, startDate, endDate, type, alertType, zones);
  }
}
