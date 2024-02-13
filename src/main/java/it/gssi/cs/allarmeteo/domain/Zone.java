package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zones")
public class Zone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Lob
  @Column(name = "description", nullable = false)
  private String description;

  @ManyToMany
  @JoinTable(
      name = "zones_provinces",
      joinColumns = @JoinColumn(name = "zone_id"),
      inverseJoinColumns = @JoinColumn(name = "provinces_id"))
  private Set<Province> provinces = new HashSet<>();

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

  public Set<Province> getProvinces() {
    return provinces;
  }

  public void setProvinces(Set<Province> provinces) {
    this.provinces = provinces;
  }

  public void addProvince(Province province) {
    provinces.add(province);
  }

  public void removeProvince(Province province) {
    provinces.remove(province);
  }
}
