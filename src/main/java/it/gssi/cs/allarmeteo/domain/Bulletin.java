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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bulletins")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Bulletin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Lob
  @Column(name = "bulletin_text", nullable = false)
  private String text;

  @OneToMany(mappedBy = "bulletin", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<CriticalitySituation> criticalitySituations = new HashSet<>();

  @Enumerated(EnumType.STRING)
  @Column(name = "state", nullable = false)
  private BulletinState state;

  @ManyToOne(optional = false)
  @JoinColumn(name = "issuer_id", nullable = false)
  private User issuer;

  @Column(name = "issued_date", nullable = false)
  private LocalDateTime issuedDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Set<CriticalitySituation> getCriticalitySituations() {
    return criticalitySituations;
  }

  public void setCriticalitySituations(Set<CriticalitySituation> criticalitySituations) {
    this.criticalitySituations = criticalitySituations;
  }

  public BulletinState getState() {
    return state;
  }

  public void setState(BulletinState state) {
    this.state = state;
  }

  public User getIssuer() {
    return issuer;
  }

  public void setIssuer(User issuer) {
    this.issuer = issuer;
  }

  public LocalDateTime getIssuedDate() {
    return issuedDate;
  }

  public void setIssuedDate(LocalDateTime issuedDate) {
    this.issuedDate = issuedDate;
  }
}
