package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "surname", nullable = false)
  private String surname;

  @Column(name = "password", nullable = false)
  private String password;

  @Temporal(TemporalType.DATE)
  @Column(name = "joined_date", nullable = false)
  private Date joinedDate;

  @Embedded private EmailAddress emailAddress;

  @Embedded private Address address;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "profile_image_id")
  private Image profileImage;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "public_body_staff_id")
  private PublicBodyStaff publicBodyStaff;

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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getJoinedDate() {
    return joinedDate;
  }

  public void setJoinedDate(Date joinedDate) {
    this.joinedDate = joinedDate;
  }

  public EmailAddress getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(EmailAddress emailAddress) {
    this.emailAddress = emailAddress;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Image getProfileImage() {
    return profileImage;
  }

  public void setProfileImage(Image profileImage) {
    this.profileImage = profileImage;
  }

  public PublicBodyStaff getPublicBodyStaff() {
    return publicBodyStaff;
  }

  public void setPublicBodyStaff(PublicBodyStaff publicBodyStaff) {
    this.publicBodyStaff = publicBodyStaff;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id)
        && Objects.equals(name, user.name)
        && Objects.equals(surname, user.surname)
        && Objects.equals(password, user.password)
        && Objects.equals(joinedDate, user.joinedDate)
        && Objects.equals(emailAddress, user.emailAddress)
        && Objects.equals(address, user.address)
        && Objects.equals(profileImage, user.profileImage)
        && Objects.equals(publicBodyStaff, user.publicBodyStaff);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        name,
        surname,
        password,
        joinedDate,
        emailAddress,
        address,
        profileImage,
        publicBodyStaff);
  }
}
