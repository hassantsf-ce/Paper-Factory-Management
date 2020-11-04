package ir.ac.kntu;

public class Customer {
  private String name;
  private String nationalNumber;

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
}
