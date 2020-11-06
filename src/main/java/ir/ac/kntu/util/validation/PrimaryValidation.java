package ir.ac.kntu.util.validation;

import ir.ac.kntu.exceptions.EmptyStringException;
import ir.ac.kntu.exceptions.NegativeValueException;
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

  public void validateNegativeNumber(Number number) throws NegativeValueException {
    if (number.doubleValue() < 0 || number.intValue() < 0) {
      throw new NegativeValueException();
    }
  }
}
