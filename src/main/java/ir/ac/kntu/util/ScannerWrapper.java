package ir.ac.kntu.util;

import java.util.Scanner;

public class ScannerWrapper {
  private static Scanner scanner;
  private static final ScannerWrapper scannerWrapper = new ScannerWrapper();

  private ScannerWrapper() {
    scanner = new Scanner(System.in);
  }

  public static ScannerWrapper getInstance() {
    return scannerWrapper;
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
}
