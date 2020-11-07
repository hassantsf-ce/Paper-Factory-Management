package ir.ac.kntu.model;

import java.util.Objects;

public class Customer {
  private String name;
  private String nationalNumber;

  // Default Constructor for jackson
  public Customer() {
  }

  public Customer(String name, String nationalNumber) {
    this.name = name;
    this.nationalNumber = nationalNumber;
  }

  public String getName() {
    return name;
  }

  public String getNationalNumber() {
    return nationalNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNationalNumber(String nationalNumber) {
    this.nationalNumber = nationalNumber;
  }


  @Override
  public String toString() {
    return "Customer " + nationalNumber + " {" +
            "\n\t- name: " + name + "\n}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return Objects.equals(name, customer.name) &&
            Objects.equals(nationalNumber, customer.nationalNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, nationalNumber);
  }
}
