package ir.ac.kntu.exceptions;

public class EmptyStringException extends Exception {
  public EmptyStringException() {
    super("String is empty");
  }
}
