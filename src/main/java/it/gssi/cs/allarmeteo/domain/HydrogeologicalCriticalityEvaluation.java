package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("hydrogeological")
public class HydrogeologicalCriticalityEvaluation extends CriticalityEvaluation {
  @ElementCollection
  @CollectionTable(
      name = "hydrogeological_criticality_evaluation_ground_moisture_situations",
      joinColumns = @JoinColumn(name = "hydrogeological_criticality_evaluation_id"))
  private Set<GroundMoistureSituation> groundMoistureSituations = new HashSet<>();

  @OneToMany(
      mappedBy = "hydrogeologicalCriticalityEvaluation",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private Set<QPFevaluation> qpfEvaluations = new HashSet<>();

  public Set<GroundMoistureSituation> getGroundMoistureSituations() {
    return groundMoistureSituations;
  }

  public void setGroundMoistureSituations(Set<GroundMoistureSituation> groundMoistureSituations) {
    this.groundMoistureSituations = groundMoistureSituations;
  }

  public void addGroundMoistureSituation(GroundMoistureSituation groundMoistureSituation) {
    this.groundMoistureSituations.add(groundMoistureSituation);
  }

  public void removeGroundMoistureSituation(GroundMoistureSituation groundMoistureSituation) {
    this.groundMoistureSituations.remove(groundMoistureSituation);
  }

  public Set<QPFevaluation> getQPFevaluations() {
    return qpfEvaluations;
  }

  public void setQPFevaluations(Set<QPFevaluation> qpfEvaluations) {
    this.qpfEvaluations = qpfEvaluations;
  }

  public void addQPFevaluation(QPFevaluation qpfEvaluation) {
    this.qpfEvaluations.add(qpfEvaluation);
  }

  public void removeQPFevaluation(QPFevaluation qpfEvaluation) {
    this.qpfEvaluations.remove(qpfEvaluation);
  }
}
