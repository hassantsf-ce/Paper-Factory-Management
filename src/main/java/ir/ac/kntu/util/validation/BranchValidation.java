package ir.ac.kntu.util.validation;

import ir.ac.kntu.exceptions.EmptyStringException;
import ir.ac.kntu.exceptions.NullValueException;
import ir.ac.kntu.exceptions.ShortLengthStringException;

public class BranchValidation extends PrimaryValidation {
  public void validateBranchCode(String code) throws ShortLengthStringException,
          EmptyStringException, NullValueException {
    this.validateString(code);

    final int LENGTH_LIMIT = 3;
    if (code.length() < LENGTH_LIMIT) {
      throw new ShortLengthStringException();
    }
  }
}
