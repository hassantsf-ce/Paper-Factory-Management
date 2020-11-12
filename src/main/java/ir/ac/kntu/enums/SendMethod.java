package ir.ac.kntu.enums;

public enum SendMethod {
  AIR_MAIL,
  GROUND_MAIL,
  SEA_MAIL;

  public static String[] getStringValues() {
    String[] values = new String[3];
    values[0] = AIR_MAIL.toString();
    values[1] = GROUND_MAIL.toString();
    values[2] = SEA_MAIL.toString();
    return values;
  }
}
