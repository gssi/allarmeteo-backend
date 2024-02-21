package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Objects;

@Embeddable
public class GroundSnowSituation {
  @OneToOne(optional = false)
  @JoinColumn(name = "zone_id", nullable = false)
  private Zone zone;

  @Column(name = "snow_presence", nullable = false)
  private Boolean snowPresence = false;

  @Column(name = "note")
  private String note;

  public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }

  public Boolean getSnowPresence() {
    return snowPresence;
  }

  public void setSnowPresence(Boolean snowPresence) {
    this.snowPresence = snowPresence;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroundSnowSituation that = (GroundSnowSituation) o;
    return Objects.equals(zone, that.zone)
        && Objects.equals(snowPresence, that.snowPresence)
        && Objects.equals(note, that.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(zone, snowPresence, note);
  }
}
