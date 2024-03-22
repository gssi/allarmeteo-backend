package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("public_body_staff")
public class PublicBodyStaff extends User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "public_body_id")
  private PublicBody publicBody;

  @Column(name = "is_public_body_admin", nullable = false)
  private Boolean isPublicBodyAdmin = false;

  @ManyToMany
  @JoinTable(
      name = "public_body_staff_risks",
      joinColumns = @JoinColumn(name = "public_body_staff_id"),
      inverseJoinColumns = @JoinColumn(name = "risks_id"))
  private Set<Risk> risks = new HashSet<>();

  @ElementCollection
  @CollectionTable(
      name = "public_body_staff_emails",
      joinColumns = @JoinColumn(name = "public_body_staff_id"))
  private Set<EmailAddress> emails = new HashSet<>();

  @ElementCollection
  @CollectionTable(
      name = "public_body_staff_phoneNumbers",
      joinColumns = @JoinColumn(name = "public_body_staff_id"))
  private Set<PhoneNumber> phoneNumbers = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PublicBody getPublicBody() {
    return publicBody;
  }

  public void setPublicBody(PublicBody publicBody) {
    this.publicBody = publicBody;
  }

  public Boolean getPublicBodyAdmin() {
    return isPublicBodyAdmin;
  }

  public void setPublicBodyAdmin(Boolean publicBodyAdmin) {
    isPublicBodyAdmin = publicBodyAdmin;
  }

  public Set<Risk> getRisks() {
    return risks;
  }

  public void setRisks(Set<Risk> risks) {
    this.risks = risks;
  }

  public Set<EmailAddress> getEmails() {
    return emails;
  }

  public void setEmails(Set<EmailAddress> emails) {
    this.emails = emails;
  }

  public void addEmail(EmailAddress emailAddress) {
    this.emails.add(emailAddress);
  }

  public void removeEmail(EmailAddress emailAddress) {
    this.emails.remove(emailAddress);
  }

  public Set<PhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  public void addPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumbers.add(phoneNumber);
  }

  public void removePhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumbers.remove(phoneNumber);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    PublicBodyStaff that = (PublicBodyStaff) o;
    return Objects.equals(id, that.id)
        && Objects.equals(publicBody, that.publicBody)
        && Objects.equals(isPublicBodyAdmin, that.isPublicBodyAdmin)
        && Objects.equals(emails, that.emails)
        && Objects.equals(phoneNumbers, that.phoneNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), id, publicBody, isPublicBodyAdmin, emails, phoneNumbers);
  }
}
