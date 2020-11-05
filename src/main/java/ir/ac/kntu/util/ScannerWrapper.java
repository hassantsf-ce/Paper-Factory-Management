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

  public static String getString() {
    return scanner.next();
  }

  public static double getDouble() {
    return scanner.nextDouble();
  }

  public static double getLong() {
    return scanner.nextLong();
  }
}
