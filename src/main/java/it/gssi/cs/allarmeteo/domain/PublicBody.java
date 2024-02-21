package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "public_bodies")
public class PublicBody {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Lob
  @Column(name = "public_body_description", nullable = false)
  private String description;

  @Column(name = "website", nullable = false)
  private String website;

  @Column(name = "is_city_hall", nullable = false)
  private Boolean isCityHall = false;

  @Embedded private Address address;

  @Embedded private PhoneNumber phoneNumber;

  @Embedded private EmailAddress emailAddress;

  @OneToMany(mappedBy = "publicBody", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<PublicBodyStaff> staff = new HashSet<>();

  @OneToMany(mappedBy = "publicBody", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<PublicBodyRiskTypeZone> riskTypesZones = new HashSet<>();

  @OneToMany(mappedBy = "publicBody", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Report> reports = new HashSet<>();

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

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public Boolean getCityHall() {
    return isCityHall;
  }

  public void setCityHall(Boolean cityHall) {
    isCityHall = cityHall;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public EmailAddress getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(EmailAddress emailAddress) {
    this.emailAddress = emailAddress;
  }

  public Set<PublicBodyStaff> getStaff() {
    return staff;
  }

  public void setStaff(Set<PublicBodyStaff> staff) {
    this.staff = staff;
  }

  public void addStaffMember(PublicBodyStaff staffMember) {
    this.staff.add(staffMember);
  }

  public void removeStaffMember(PublicBodyStaff staffMember) {
    this.staff.remove(staffMember);
  }

  public Set<PublicBodyRiskTypeZone> getRiskTypesZones() {
    return riskTypesZones;
  }

  public void setRiskTypesZones(Set<PublicBodyRiskTypeZone> riskTypesZones) {
    this.riskTypesZones = riskTypesZones;
  }

  public void addRiskTypeZone(PublicBodyRiskTypeZone publicBodyRiskTypeZone) {
    this.riskTypesZones.add(publicBodyRiskTypeZone);
  }

  public void removeRiskTypeZone(PublicBodyRiskTypeZone publicBodyRiskTypeZone) {
    for (PublicBodyRiskTypeZone publicBodyRiskTypeZoneItem : this.riskTypesZones) {
      if (publicBodyRiskTypeZoneItem.getPublicBody().equals(this)
          && publicBodyRiskTypeZoneItem.getRiskType().equals(publicBodyRiskTypeZone.getRiskType())
          && publicBodyRiskTypeZoneItem.getZone().equals(publicBodyRiskTypeZone.getZone())) {
        this.riskTypesZones.remove(publicBodyRiskTypeZoneItem);
      }
    }
  }

  public Set<Report> getReports() {
    return reports;
  }

  public void setReports(Set<Report> reports) {
    this.reports = reports;
  }

  public void addReport(Report report) {
    this.reports.add(report);
    report.getZone().getReports().add(report);
  }

  public void removeReport(Report report) {
    for (Report reportItem : this.getReports()) {
      if (reportItem.getPublicBody().equals(this)
          && reportItem.getZone().equals(report.getZone())
          && reportItem.getRiskType().equals(report.getRiskType())) {
        this.reports.remove(reportItem);
        reportItem.getZone().getReports().remove(reportItem);
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PublicBody that = (PublicBody) o;
    return Objects.equals(id, that.id)
        && Objects.equals(name, that.name)
        && Objects.equals(description, that.description)
        && Objects.equals(website, that.website)
        && Objects.equals(isCityHall, that.isCityHall)
        && Objects.equals(address, that.address)
        && Objects.equals(phoneNumber, that.phoneNumber)
        && Objects.equals(emailAddress, that.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, name, description, website, isCityHall, address, phoneNumber, emailAddress);
  }
}
