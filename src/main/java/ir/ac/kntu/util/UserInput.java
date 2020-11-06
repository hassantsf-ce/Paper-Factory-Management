package ir.ac.kntu.util;

public class UserInput {
  private final ScannerWrapper SCANNER = ScannerWrapper.getInstance();

  public int getInt(String fieldName) {
    System.out.println("Enter " + fieldName + ":");
    int input = SCANNER.getInt();
    return input;
  }

  public String getString(String fieldName) {
    System.out.println("Enter " + fieldName + ":");
    String input = SCANNER.getString();
    return input;
  }

  public long getLong(String fieldName) {
    System.out.println("Enter " + fieldName + ":");
    long input = SCANNER.getLong();
    return input;
  }

  public double getDouble(String fieldName) {
    System.out.println("Enter " + fieldName + ":");
    double input = SCANNER.getDouble();
    return input;
  }

  public String getLine(String fieldName) {
    System.out.println("Enter " + fieldName + ":");
    String input = SCANNER.getLine();
    return input;
  }
}