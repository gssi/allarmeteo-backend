package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Objects;

@Embeddable
public class EmailAddress {

  @Column(name = "email_address", nullable = false)
  private String email;

  @Enumerated(EnumType.STRING)
  @Column(name = "email_address_type", nullable = false)
  private EmailType type;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EmailType getType() {
    return type;
  }

  public void setType(EmailType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EmailAddress that = (EmailAddress) o;
    return Objects.equals(email, that.email) && type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, type);
  }
}
