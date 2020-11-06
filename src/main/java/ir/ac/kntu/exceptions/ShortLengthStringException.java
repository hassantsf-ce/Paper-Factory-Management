package ir.ac.kntu.exceptions;

public class ShortLengthStringException extends Exception {
  public ShortLengthStringException() {
    super("Passed content is too short");
  }
}
