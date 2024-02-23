package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ExpectedRainfall {
  @Column(name = "expected_rainfall_amount", nullable = false)
  private Integer amount;

  @Column(name = "expected_rainfall_hours_number", nullable = false)
  private Integer hoursNumber;

  public Integer getHoursNumber() {
    return hoursNumber;
  }

  public void setHoursNumber(Integer hoursNumber) {
    this.hoursNumber = hoursNumber;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExpectedRainfall that = (ExpectedRainfall) o;
    return Objects.equals(amount, that.amount) && Objects.equals(hoursNumber, that.hoursNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, hoursNumber);
  }
}
