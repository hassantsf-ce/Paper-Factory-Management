package ir.ac.kntu.model;

import java.util.Objects;

public class City {
  private String name;
  private String state;

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

  @Override
  public String toString() {
    return "City: " +
            "\n-name: " + name +
            "\n-state: " + state;
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
}
