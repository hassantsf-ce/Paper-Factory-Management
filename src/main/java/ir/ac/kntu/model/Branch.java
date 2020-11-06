package ir.ac.kntu.model;

import java.util.Objects;

public class Branch {
  private String code;
  private City city;
  private int personnelNumbers;

  public Branch(String code, City city, int personnelNumbers) {
    this.code = code;
    this.city = city;
    this.personnelNumbers = personnelNumbers;
  }

  public String getCode() {
    return code;
  }

  public City getCity() {
    return city;
  }

  public int getPersonnelNumbers() {
    return personnelNumbers;
  }

  @Override
  public String toString() {
    return "Branch: " + code  +
            "\n-" + city +
            "\n-personnelNumbers: " + personnelNumbers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Branch branch = (Branch) o;
    return personnelNumbers == branch.personnelNumbers &&
            Objects.equals(code, branch.code) &&
            Objects.equals(city, branch.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, city, personnelNumbers);
  }
}
