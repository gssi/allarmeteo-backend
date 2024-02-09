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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "regions")
public class Region {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "country_id")
  private Country country;

  @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
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

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public Set<Province> getProvinces() {
    return provinces;
  }

  public void setProvinces(Set<Province> provinces) {
    this.provinces = provinces;
  }

  public void addProvince(Province province) {
    this.provinces.add(province);
  }

  public void removeProvince(Province province) {
    this.provinces.remove(province);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Region region = (Region) o;
    return Objects.equals(id, region.id) && Objects.equals(name, region.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
