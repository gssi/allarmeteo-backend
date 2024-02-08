package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.HashSet;
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

  @ElementCollection
  @CollectionTable(name = "public_body_staff_emails", joinColumns = @JoinColumn(name = "owner_id"))
  private Set<EmailAddress> emails = new HashSet<>();

  @ElementCollection
  @CollectionTable(
      name = "public_body_staff_phoneNumbers",
      joinColumns = @JoinColumn(name = "owner_id"))
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

  public Set<EmailAddress> getEmails() {
    return emails;
  }

  public void setEmails(Set<EmailAddress> emails) {
    this.emails = emails;
  }

  public Set<PhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }
}
