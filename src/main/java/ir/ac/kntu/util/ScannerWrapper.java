package ir.ac.kntu.util;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerWrapper {
  private static Scanner scanner;
  private static ScannerWrapper scannerWrapper = new ScannerWrapper();

  private ScannerWrapper() {
    scanner = new Scanner(System.in);
  }

  public static ScannerWrapper getInstance() {
    return scannerWrapper;
  }

  public static void setIn(String text) {
    InputStream stream = new ByteArrayInputStream(text.getBytes());
    System.setIn(stream);
    scannerWrapper = new ScannerWrapper();
  }

  public int getInt() {
    return scanner.nextInt();
  }

  public String getString() {
    return scanner.next();
  }

  public double getDouble() {
    return scanner.nextDouble();
  }

  public long getLong() {
    return scanner.nextLong();
  }

  public String getLine() {
    return scanner.nextLine();
  }
}
