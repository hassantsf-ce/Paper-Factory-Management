package ir.ac.kntu.model;

import ir.ac.kntu.view.ViewAsHtml;

import java.util.Objects;

public class Branch implements ViewAsHtml {
  private String code;
  private City city;
  private int personnelNumbers;

  // Default Constructor for jackson
  public Branch() {
  }

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

  public void setCode(String code) {
    this.code = code;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public void setPersonnelNumbers(int personnelNumbers) {
    this.personnelNumbers = personnelNumbers;
  }

  @Override
  public String toString() {
    return "Branch " + code + " [" +
            "\n\t" + city +
            "\n\t-personnelNumbers: " + personnelNumbers + "\n]";
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

  @Override
  public String generateHtml() {
    return "<td>" + code + " from " + city.getName() + "</td>";
  }
}
