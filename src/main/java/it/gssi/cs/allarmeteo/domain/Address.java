package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class Address {

  @Column(name = "street", nullable = false)
  private String street;

  @Column(name = "street_number", nullable = false)
  private Integer streetNumber;

  @OneToOne
  @JoinColumn(name = "city_id")
  private City city;

  @OneToOne
  @JoinColumn(name = "province_id")
  private Province province;

  @OneToOne
  @JoinColumn(name = "region_id")
  private Region region;

  @OneToOne
  @JoinColumn(name = "country_id")
  private Country country;

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Integer getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(Integer streetNumber) {
    this.streetNumber = streetNumber;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public Province getProvince() {
    return province;
  }

  public void setProvince(Province province) {
    this.province = province;
  }

  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }
}
