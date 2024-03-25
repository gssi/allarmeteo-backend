package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "weather_conditions")
public class WeatherCondition {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Lob
  @Column(name = "weather_condition_description", nullable = false)
  private String description;

  @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
  @JoinColumn(name = "icon_id", nullable = false)
  private Image icon;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Image getIcon() {
    return icon;
  }

  public void setIcon(Image icon) {
    this.icon = icon;
  }
}
