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
@Table(name = "qpf_evaluations")
public class QPFevaluation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDateTime endDate;

  @OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<QPFevaluationItem> evaluationItems = new HashSet<>();

  @ManyToOne(optional = false)
  @JoinColumn(name = "hydrogeological_criticality_evaluation_id", nullable = false)
  private HydrogeologicalCriticalityEvaluation hydrogeologicalCriticalityEvaluation;

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

  public Set<QPFevaluationItem> getEvaluationItems() {
    return evaluationItems;
  }

  public void setEvaluationItems(Set<QPFevaluationItem> evaluationItems) {
    this.evaluationItems = evaluationItems;
  }

  public HydrogeologicalCriticalityEvaluation getHydrogeologicalCriticalityEvaluation() {
    return hydrogeologicalCriticalityEvaluation;
  }

  public void setHydrogeologicalCriticalityEvaluation(
      HydrogeologicalCriticalityEvaluation hydrogeologicalCriticalityEvaluation) {
    this.hydrogeologicalCriticalityEvaluation = hydrogeologicalCriticalityEvaluation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    QPFevaluation that = (QPFevaluation) o;
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
