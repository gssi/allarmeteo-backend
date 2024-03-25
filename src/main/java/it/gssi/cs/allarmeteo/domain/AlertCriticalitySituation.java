package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("criticality_situation")
public class AlertCriticalitySituation extends Alert {
  @Embedded private CriticalitySituationItem criticalitySituationItem;

  @ManyToOne
  @JoinColumn(name = "bulletin_id")
  private Bulletin bulletin;

  public CriticalitySituationItem getCriticalitySituationItem() {
    return criticalitySituationItem;
  }

  public void setCriticalitySituationItem(CriticalitySituationItem criticalitySituationItem) {
    this.criticalitySituationItem = criticalitySituationItem;
  }

  public Bulletin getBulletin() {
    return bulletin;
  }

  public void setBulletin(Bulletin bulletin) {
    this.bulletin = bulletin;
  }
}
