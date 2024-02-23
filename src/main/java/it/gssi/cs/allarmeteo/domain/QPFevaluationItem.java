package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "qpf_evaluation_items")
public class QPFevaluationItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "zone_id", nullable = false)
  private Zone zone;

  @Enumerated(EnumType.STRING)
  @Column(name = "expected_rainfall_type")
  private RainfallType expectedRainfallType;

  @Enumerated(EnumType.STRING)
  @Column(name = "expected_storm_type")
  private StormType expectedStormType;

  @ElementCollection
  @CollectionTable(
      name = "qpf_evaluation_items_maximum_expected_rainfalls",
      joinColumns = @JoinColumn(name = "qpf_evaluation_item_id"))
  private Set<ExpectedRainfall> maximumExpectedRainfalls = new HashSet<>();

  @Column(name = "rainfall_threshold_exceeded")
  private Boolean rainfallThresholdExceeded;

  @ManyToOne
  @JoinColumn(name = "rainfall_criticality_level_id")
  private CriticalityLevel rainfallCriticalityLevel;

  @Column(name = "storm_criticality")
  private Boolean stormCriticality;

  @ManyToOne
  @JoinColumn(name = "storm_criticality_level_id")
  private CriticalityLevel stormCriticalityLevel;

  @ManyToOne(optional = false)
  @JoinColumn(name = "evaluation_id", nullable = false)
  private QPFevaluation evaluation;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    QPFevaluationItem that = (QPFevaluationItem) o;
    return Objects.equals(id, that.id)
        && Objects.equals(zone, that.zone)
        && expectedRainfallType == that.expectedRainfallType
        && expectedStormType == that.expectedStormType
        && Objects.equals(maximumExpectedRainfalls, that.maximumExpectedRainfalls)
        && Objects.equals(rainfallThresholdExceeded, that.rainfallThresholdExceeded)
        && Objects.equals(rainfallCriticalityLevel, that.rainfallCriticalityLevel)
        && Objects.equals(stormCriticality, that.stormCriticality)
        && Objects.equals(stormCriticalityLevel, that.stormCriticalityLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        zone,
        expectedRainfallType,
        expectedStormType,
        maximumExpectedRainfalls,
        rainfallThresholdExceeded,
        rainfallCriticalityLevel,
        stormCriticality,
        stormCriticalityLevel);
  }
}
