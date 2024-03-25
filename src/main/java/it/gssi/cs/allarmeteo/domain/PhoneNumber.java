package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class PhoneNumber {
  @Column(name = "phone_number", nullable = false, length = 20)
  private String number;

  @Enumerated(EnumType.STRING)
  @Column(name = "phone_number_type", nullable = false)
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PhoneNumber that = (PhoneNumber) o;
    return Objects.equals(number, that.number) && type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, type);
  }
}
