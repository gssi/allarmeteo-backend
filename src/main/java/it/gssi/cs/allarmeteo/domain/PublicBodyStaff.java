package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "public_body_staff")
public class PublicBodyStaff {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToOne(mappedBy = "publicBodyStaff")
  private User user;

  @ManyToOne
  @JoinColumn(name = "public_body_id")
  private PublicBody publicBody;

  @Column(name = "is_public_body_admin", nullable = false)
  private Boolean isPublicBodyAdmin = false;

  @ElementCollection
  @CollectionTable(name = "public_body_staff_emails", joinColumns = @JoinColumn(name = "public_body_staff_id"))
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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
    PublicBodyStaff that = (PublicBodyStaff) o;
    return Objects.equals(id, that.id)
        && Objects.equals(user, that.user)
        && Objects.equals(publicBody, that.publicBody)
        && Objects.equals(isPublicBodyAdmin, that.isPublicBodyAdmin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, user, publicBody, isPublicBodyAdmin);
  }
}
