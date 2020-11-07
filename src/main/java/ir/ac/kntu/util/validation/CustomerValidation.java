package ir.ac.kntu.util.validation;

import ir.ac.kntu.exceptions.InvalidNationalNumberException;
import ir.ac.kntu.exceptions.ShortLengthStringException;

public class CustomerValidation extends PrimaryValidation {
  public void validateCustomerName(String customerName) throws ShortLengthStringException {
    final int NAME_LENGTH = 3;
    if (customerName.length() < NAME_LENGTH) {
      throw new ShortLengthStringException();
    }
  }

  public void validateNationalNumber(String customerNationalNumber) throws InvalidNationalNumberException {
    final int NATIONAL_NUMBER_LENGTH = 10;
    if (customerNationalNumber.length() != NATIONAL_NUMBER_LENGTH) {
      throw new InvalidNationalNumberException("National number length should be exact 10!");
    }

    if (!customerNationalNumber.matches("\\d+")) {
      throw new InvalidNationalNumberException("National number should be contain only digits!");
    }
  }
}
