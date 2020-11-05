package ir.ac.kntu.exceptions;

public class NullValueException extends Exception {
  public NullValueException() {
    super("Null value has been passed!");
  }
}
