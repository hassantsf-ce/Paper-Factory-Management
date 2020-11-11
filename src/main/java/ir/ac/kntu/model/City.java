package ir.ac.kntu.model;

import ir.ac.kntu.view.ViewAsHtml;

import java.util.Objects;

public class City implements ViewAsHtml {
  private String name;
  private String state;

  // Default Constructor for jackson
  public City() {}

  public City(String name, String state) {
    this.name = name;
    this.state = state;
  }

  public String getName() {
    return name;
  }

  public String getState() {
    return state;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "City {" +
            "\n\t\t-name: " + name +
            "\n\t\t-state: " + state + "\n\t\t}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    City city = (City) o;
    return Objects.equals(name, city.name) &&
            Objects.equals(state, city.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, state);
  }

  public String generateHtml() {
    return "<td>" + name + "(" + state + ")" + "</td>";
  }
}
