package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "avalanche_evaluations")
public class AvalancheEvaluation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDateTime endDate;

  @OneToMany(mappedBy = "avalancheEvaluation", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<AvalancheEvaluationItem> evaluationItems = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "avalanche_criticality_evaluation_id")
  private AvalancheCriticalityEvaluation avalancheCriticalityEvaluation;

  public AvalancheCriticalityEvaluation getAvalancheCriticalityEvaluation() {
    return avalancheCriticalityEvaluation;
  }

  public void setAvalancheCriticalityEvaluation(
      AvalancheCriticalityEvaluation avalancheCriticalityEvaluation) {
    this.avalancheCriticalityEvaluation = avalancheCriticalityEvaluation;
  }

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

  public Set<AvalancheEvaluationItem> getEvaluationItems() {
    return evaluationItems;
  }

  public void setEvaluationItems(Set<AvalancheEvaluationItem> evaluationItems) {
    this.evaluationItems = evaluationItems;
  }

  public void addEvaluationItem(AvalancheEvaluationItem evaluationItem) {
    this.evaluationItems.add(evaluationItem);
  }

  public void removeEvaluationItem(AvalancheEvaluationItem evaluationItem) {
    this.evaluationItems.remove(evaluationItem);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AvalancheEvaluation that = (AvalancheEvaluation) o;
    return Objects.equals(id, that.id)
        && Objects.equals(startDate, that.startDate)
        && Objects.equals(endDate, that.endDate)
        && Objects.equals(evaluationItems, that.evaluationItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, startDate, endDate, evaluationItems);
  }
}
