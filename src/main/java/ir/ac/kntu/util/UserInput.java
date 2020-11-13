package ir.ac.kntu.util;

import ir.ac.kntu.exceptions.InvalidDateException;

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

  public JalaliCalendar getDate(String fieldName) throws InvalidDateException {
    System.out.println("Enter " + fieldName + "(yyyy/mm/dd)");
    String input = SCANNER.getLine();
    String[] parts = input.split("[/-]");;
    try {
      int year = Integer.parseInt(parts[0]);
      int month = Integer.parseInt(parts[1]);
      int day = Integer.parseInt(parts[2]);
      return new JalaliCalendar(year, month, day);
    } catch (NumberFormatException e) {
      System.out.println("Wrong Format");
      throw new InvalidDateException("date");
    }
  }

  public int chooseFromList(String[] options) {
    System.out.println("Choose from");
    for (int i = 0; i < options.length; i++) {
      System.out.printf("%d) %s\n", i + 1, options[i]);
    }

    int choice = SCANNER.getInt();
    while (choice > options.length || choice <= 0) {
      System.out.println("Invalid option. Try again!");
      choice = SCANNER.getInt();
    }

    return choice;
  }
}