package ir.ac.kntu.enums;

public enum PostType {
  ORDINARY,
  CERTIFIED;

  public static String[] getStringValues() {
    String[] values = new String[2];
    values[0] = ORDINARY.toString();
    values[1] = CERTIFIED.toString();
    return values;
  }
}
