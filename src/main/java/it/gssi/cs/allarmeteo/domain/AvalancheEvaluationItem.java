package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "avalanche_evaluation_items")
public class AvalancheEvaluationItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "zone_id")
  private Zone zone;

  @Enumerated(EnumType.STRING)
  @Column(name = "expected_danger_level")
  private AvalancheDangerLevel expectedDangerLevel;

  @Column(name = "critical_snow_height")
  private Integer criticalSnowHeight;

  @Enumerated(EnumType.STRING)
  @Column(name = "avalanche_problem")
  private AvalancheProblemType avalancheProblem;

  @ManyToOne
  @JoinColumn(name = "criticality_level_id")
  private CriticalityLevel criticalityLevel;

  @ManyToOne
  @JoinColumn(name = "avalanche_evaluation_id")
  private AvalancheEvaluation avalancheEvaluation;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }

  public AvalancheDangerLevel getExpectedDangerLevel() {
    return expectedDangerLevel;
  }

  public void setExpectedDangerLevel(AvalancheDangerLevel expectedDangerLevel) {
    this.expectedDangerLevel = expectedDangerLevel;
  }

  public Integer getCriticalSnowHeight() {
    return criticalSnowHeight;
  }

  public void setCriticalSnowHeight(Integer criticalSnowHeight) {
    this.criticalSnowHeight = criticalSnowHeight;
  }

  public AvalancheProblemType getAvalancheProblem() {
    return avalancheProblem;
  }

  public void setAvalancheProblem(AvalancheProblemType avalancheProblem) {
    this.avalancheProblem = avalancheProblem;
  }

  public CriticalityLevel getCriticalityLevel() {
    return criticalityLevel;
  }

  public void setCriticalityLevel(CriticalityLevel criticalityLevel) {
    this.criticalityLevel = criticalityLevel;
  }

  public AvalancheEvaluation getAvalancheEvaluation() {
    return avalancheEvaluation;
  }

  public void setAvalancheEvaluation(AvalancheEvaluation avalancheEvaluation) {
    this.avalancheEvaluation = avalancheEvaluation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AvalancheEvaluationItem that = (AvalancheEvaluationItem) o;
    return Objects.equals(id, that.id)
        && Objects.equals(zone, that.zone)
        && expectedDangerLevel == that.expectedDangerLevel
        && Objects.equals(criticalSnowHeight, that.criticalSnowHeight)
        && avalancheProblem == that.avalancheProblem
        && Objects.equals(criticalityLevel, that.criticalityLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, zone, expectedDangerLevel, criticalSnowHeight, avalancheProblem, criticalityLevel);
  }
}
