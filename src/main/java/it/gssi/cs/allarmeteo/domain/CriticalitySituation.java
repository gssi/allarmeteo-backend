package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "criticality_situations")
public class CriticalitySituation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDateTime endDate;

  @ElementCollection
  @CollectionTable(
      name = "criticality_situations_criticality_situation_items",
      joinColumns = @JoinColumn(name = "criticality_situation_id"))
  private Set<CriticalitySituationItem> criticalitySituationItems = new HashSet<>();

  @Lob
  @Column(name = "note")
  private String note;

  @ManyToOne
  @JoinColumn(name = "criticality_evaluation_id")
  private CriticalityEvaluation criticalityEvaluation;

  @ManyToOne
  @JoinColumn(name = "bulletin_id")
  private Bulletin bulletin;

  @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
  @JoinColumn(name = "image_id")
  private Image map;

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

  public Set<CriticalitySituationItem> getCriticalitySituationItems() {
    return criticalitySituationItems;
  }

  public void setCriticalitySituationItems(
      Set<CriticalitySituationItem> criticalitySituationItems) {
    this.criticalitySituationItems = criticalitySituationItems;
  }

  public void addCriticalitySituationItem(CriticalitySituationItem criticalitySituationItem) {
    this.criticalitySituationItems.add(criticalitySituationItem);
  }

  public void removeCriticalitySituationItem(CriticalitySituationItem criticalitySituationItem) {
    this.criticalitySituationItems.remove(criticalitySituationItem);
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public CriticalityEvaluation getCriticalityEvaluation() {
    return criticalityEvaluation;
  }

  public void setCriticalityEvaluation(CriticalityEvaluation criticalityEvaluation) {
    this.criticalityEvaluation = criticalityEvaluation;
  }

  public Bulletin getBulletin() {
    return bulletin;
  }

  public void setBulletin(Bulletin bulletin) {
    this.bulletin = bulletin;
  }

  public Image getMap() {
    return map;
  }

  public void setMap(Image map) {
    this.map = map;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CriticalitySituation that = (CriticalitySituation) o;
    return Objects.equals(id, that.id)
        && Objects.equals(startDate, that.startDate)
        && Objects.equals(endDate, that.endDate)
        && Objects.equals(criticalitySituationItems, that.criticalitySituationItems)
        && Objects.equals(note, that.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, startDate, endDate, criticalitySituationItems, note);
  }
}
