package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "risk_types_criticality_levels")
public class RiskTypeCriticalityLevel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "risk_type_id", nullable = false)
  private RiskType riskType;

  @ManyToOne(optional = false)
  @JoinColumn(name = "criticality_level_id", nullable = false)
  private CriticalityLevel criticalityLevel;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "icon_id")
  private Image icon;

  @Embedded private BehavioralProtocol behavioralProtocol;

  @ElementCollection
  @Column(name = "communication_channel_type")
  @Enumerated(EnumType.STRING)
  @CollectionTable(
      name = "risk_types_criticality_levels_communication_channel_types",
      joinColumns = @JoinColumn(name = "risk_type_criticality_level_id"))
  private Set<CommunicationChannelType> communicationChannelTypes = new HashSet<>();

  public RiskTypeCriticalityLevel() {}

  public RiskTypeCriticalityLevel(RiskType riskType, CriticalityLevel criticalityLevel) {
    this.riskType = riskType;
    this.criticalityLevel = criticalityLevel;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RiskType getRiskType() {
    return riskType;
  }

  public void setRiskType(RiskType riskType) {
    this.riskType = riskType;
  }

  public CriticalityLevel getCriticalityLevel() {
    return criticalityLevel;
  }

  public void setCriticalityLevel(CriticalityLevel criticalityLevel) {
    this.criticalityLevel = criticalityLevel;
  }

  public Image getIcon() {
    return icon;
  }

  public void setIcon(Image icon) {
    this.icon = icon;
  }

  public BehavioralProtocol getBehavioralProtocol() {
    return behavioralProtocol;
  }

  public void setBehavioralProtocol(BehavioralProtocol behavioralProtocol) {
    this.behavioralProtocol = behavioralProtocol;
  }

  public Set<CommunicationChannelType> getCommunicationChannelTypes() {
    return communicationChannelTypes;
  }

  public void setCommunicationChannelTypes(
      Set<CommunicationChannelType> communicationChannelTypes) {
    this.communicationChannelTypes = communicationChannelTypes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RiskTypeCriticalityLevel that = (RiskTypeCriticalityLevel) o;
    return Objects.equals(id, that.id)
        && Objects.equals(riskType, that.riskType)
        && Objects.equals(criticalityLevel, that.criticalityLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, riskType, criticalityLevel);
  }
}
