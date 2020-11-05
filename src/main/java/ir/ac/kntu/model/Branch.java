package ir.ac.kntu.model;

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
}
