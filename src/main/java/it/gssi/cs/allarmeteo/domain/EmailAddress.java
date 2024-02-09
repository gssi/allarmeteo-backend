package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Embeddable
public class EmailAddress {

  @Column(name = "email", nullable = false)
  private String email;

  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
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
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    Class<?> oEffectiveClass =
        o instanceof HibernateProxy
            ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
            : o.getClass();
    Class<?> thisEffectiveClass =
        this instanceof HibernateProxy
            ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
            : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) return false;
    EmailAddress that = (EmailAddress) o;
    return getEmail() != null
        && Objects.equals(getEmail(), that.getEmail())
        && getType() != null
        && Objects.equals(getType(), that.getType());
  }

  @Override
  public final int hashCode() {
    return Objects.hash(email, type);
  }
}