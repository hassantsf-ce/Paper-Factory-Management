package ir.ac.kntu.exceptions;

public class CanNotInstantiateException extends Exception {
  public CanNotInstantiateException(String objectType) {
    super("New " + objectType + " can not be instantiated!");
  }
}
