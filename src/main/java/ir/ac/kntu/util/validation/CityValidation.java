package ir.ac.kntu.util.validation;

import ir.ac.kntu.exceptions.EmptyStringException;
import ir.ac.kntu.exceptions.NullValueException;
import ir.ac.kntu.exceptions.ShortLengthStringException;

public class CityValidation extends PrimaryValidation {

  public void validateCityNameAndStateValidation(String name, String state) throws ShortLengthStringException, EmptyStringException, NullValueException {
    this.validateString(name);
    this.validateString(state);

    final int LENGTH_LIMIT = 3;
    if (name.length() < LENGTH_LIMIT || state.length() < LENGTH_LIMIT) {
      throw new ShortLengthStringException();
    }
  }
}
