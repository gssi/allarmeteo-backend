package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("criticality")
public class CriticalityBulletin extends Bulletin {
  @Column(name = "introductory_note", nullable = false)
  private String introductoryNote;

  @ElementCollection
  @Column(name = "criticality_bulletin_description")
  @CollectionTable(
      name = "criticality_bulletins_descriptions",
      joinColumns = @JoinColumn(name = "criticality_bulletin_id"))
  private Set<String> descriptions = new HashSet<>();

  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
  private CriticalityBulletinType type;

  @OneToMany(mappedBy = "criticalityBulletin", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<OperationalPhaseDeclarationItem> operationalPhaseDeclaration = new HashSet<>();

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "criticality_warning_id")
  private CriticalityWarning criticalityWarning;

  public String getIntroductoryNote() {
    return introductoryNote;
  }

  public void setIntroductoryNote(String introductoryNote) {
    this.introductoryNote = introductoryNote;
  }

  public Set<String> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(Set<String> descriptions) {
    this.descriptions = descriptions;
  }

  public CriticalityBulletinType getType() {
    return type;
  }

  public void setType(CriticalityBulletinType type) {
    this.type = type;
  }

  public Set<OperationalPhaseDeclarationItem> getOperationalPhaseDeclaration() {
    return operationalPhaseDeclaration;
  }

  public void setOperationalPhaseDeclaration(
      Set<OperationalPhaseDeclarationItem> operationalPhaseDeclaration) {
    this.operationalPhaseDeclaration = operationalPhaseDeclaration;
  }

  public CriticalityWarning getCriticalityWarning() {
    return criticalityWarning;
  }

  public void setCriticalityWarning(CriticalityWarning criticalityWarning) {
    this.criticalityWarning = criticalityWarning;
  }
}
