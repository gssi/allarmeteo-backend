package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Embeddable
public class PhoneNumber {
  @Column(name = "number", nullable = false, length = 20)
  private String number;

  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
  private PhoneNumberType type;

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public PhoneNumberType getType() {
    return type;
  }

  public void setType(PhoneNumberType type) {
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
    PhoneNumber that = (PhoneNumber) o;
    return getNumber() != null
        && Objects.equals(getNumber(), that.getNumber())
        && getType() != null
        && Objects.equals(getType(), that.getType());
  }

  @Override
  public final int hashCode() {
    return Objects.hash(number, type);
  }
}
