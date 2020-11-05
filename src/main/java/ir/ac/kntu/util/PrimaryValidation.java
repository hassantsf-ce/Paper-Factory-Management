package ir.ac.kntu.util;

import ir.ac.kntu.exceptions.EmptyStringException;
import ir.ac.kntu.exceptions.NullValueException;

public class PrimaryValidation {
  public void validateString(String string) throws EmptyStringException, NullValueException {
    if (string == null) {
      throw new NullValueException();
    }

    if (string.isEmpty()) {
      throw new EmptyStringException();
    }
  }
}
