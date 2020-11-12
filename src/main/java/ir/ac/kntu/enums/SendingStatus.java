package ir.ac.kntu.enums;

public enum SendingStatus {
  STORED,
  POSTED,
  RECEIVED;

  public static String[] getStringValues() {
    String[] values = new String[3];
    values[0] = STORED.toString();
    values[1] = POSTED.toString();
    values[2] = RECEIVED.toString();
    return values;
  }
}
