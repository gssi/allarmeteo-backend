package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("avalanche")
public class AvalancheCriticalityEvaluation extends CriticalityEvaluation {
  @OneToMany(
      mappedBy = "avalancheCriticalityEvaluation",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private Set<AvalancheEvaluation> avalancheEvaluations = new HashSet<>();

  public Set<AvalancheEvaluation> getAvalancheEvaluations() {
    return avalancheEvaluations;
  }

  public void setAvalancheEvaluations(Set<AvalancheEvaluation> avalancheEvaluations) {
    this.avalancheEvaluations = avalancheEvaluations;
  }

  public void addAvalancheEvaluation(AvalancheEvaluation avalancheEvaluation) {
    this.avalancheEvaluations.add(avalancheEvaluation);
  }

  public void removeAvalancheEvaluation(AvalancheEvaluation avalancheEvaluation) {
    this.avalancheEvaluations.remove(avalancheEvaluation);
  }
}
