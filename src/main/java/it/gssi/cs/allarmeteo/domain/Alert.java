package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "alerts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Alert {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Lob
  @Column(name = "alert_text", nullable = false)
  private String text;

  @Column(name = "sms_text", nullable = false)
  private String smsText;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private String endDate;

  @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
  @JoinColumn(name = "image_id", nullable = false)
  private Image map;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User issuer;

  @Column(name = "issued_date", nullable = false)
  private LocalDateTime issuedDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "state", nullable = false)
  private AlertState state;

  @ManyToMany
  @JoinTable(
      name = "alerts_public_bodies",
      joinColumns = @JoinColumn(name = "alert_id"),
      inverseJoinColumns = @JoinColumn(name = "public_body_id"))
  private Set<PublicBody> alertedPublicBodies = new HashSet<>();

  @OneToMany(mappedBy = "alert", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<AlertedPublicBodyStaff> alertedPublicBodyStaffs = new HashSet<>();

  public Set<AlertedPublicBodyStaff> getAlertedPublicBodyStaffs() {
    return alertedPublicBodyStaffs;
  }

  public void setAlertedPublicBodyStaffs(Set<AlertedPublicBodyStaff> alertedPublicBodyStaffs) {
    this.alertedPublicBodyStaffs = alertedPublicBodyStaffs;
  }

  public Set<PublicBody> getAlertedPublicBodies() {
    return alertedPublicBodies;
  }

  public void setAlertedPublicBodies(Set<PublicBody> alertedPublicBodies) {
    this.alertedPublicBodies = alertedPublicBodies;
  }

  public Image getMap() {
    return map;
  }

  public void setMap(Image map) {
    this.map = map;
  }

  public LocalDateTime getIssuedDate() {
    return issuedDate;
  }

  public void setIssuedDate(LocalDateTime issuedDate) {
    this.issuedDate = issuedDate;
  }

  public User getIssuer() {
    return issuer;
  }

  public void setIssuer(User issuer) {
    this.issuer = issuer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Alert alert = (Alert) o;
    return Objects.equals(id, alert.id)
        && Objects.equals(title, alert.title)
        && Objects.equals(text, alert.text)
        && Objects.equals(smsText, alert.smsText)
        && Objects.equals(startDate, alert.startDate)
        && Objects.equals(endDate, alert.endDate)
        && Objects.equals(issuer, alert.issuer)
        && Objects.equals(issuedDate, alert.issuedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, text, smsText, startDate, endDate, issuer, issuedDate);
  }
}
