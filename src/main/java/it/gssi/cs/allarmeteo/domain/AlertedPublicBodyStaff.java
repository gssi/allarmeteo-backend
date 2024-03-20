package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "alerted_public_body_staff")
public class AlertedPublicBodyStaff {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "alert_id", nullable = false)
  private Alert alert;

  @ManyToOne(optional = false)
  @JoinColumn(name = "public_body_staff_id", nullable = false)
  private PublicBodyStaff publicBodyStaff;

  @Embedded private PhoneNumber phoneNumber;

  @Embedded private EmailAddress emailAddress;

  @Enumerated(EnumType.STRING)
  @Column(name = "delivery_status", nullable = false)
  private DeliveryStatus deliveryStatus;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Alert getAlert() {
    return alert;
  }

  public void setAlert(Alert alert) {
    this.alert = alert;
  }

  public PublicBodyStaff getPublicBodyStaff() {
    return publicBodyStaff;
  }

  public void setPublicBodyStaff(PublicBodyStaff publicBodyStaff) {
    this.publicBodyStaff = publicBodyStaff;
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

  public DeliveryStatus getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AlertedPublicBodyStaff that = (AlertedPublicBodyStaff) o;
    return Objects.equals(id, that.id)
        && Objects.equals(alert, that.alert)
        && Objects.equals(publicBodyStaff, that.publicBodyStaff)
        && Objects.equals(phoneNumber, that.phoneNumber)
        && Objects.equals(emailAddress, that.emailAddress)
        && deliveryStatus == that.deliveryStatus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, alert, publicBodyStaff, phoneNumber, emailAddress, deliveryStatus);
  }
}
