package ir.ac.kntu.util.validation;

import ir.ac.kntu.util.JalaliCalendar;

public class DateValidation extends PrimaryValidation {
  private boolean validateDay(int year, int month, int day) {
    JalaliCalendar calendar = new JalaliCalendar(year, month, day);
    boolean isValid;
    if (month <= 6) {
      isValid = day <= 31;
    } else if (month <= 11) {
      isValid = day <= 30;
    } else {
      isValid = calendar.isLeap() ? day <= 29 : day <= 30;
    }

    return isValid;
  }

  private boolean validateMonth(int month) {
    return month >= 0 && month <= 12;
  }

  private boolean validateYear(int year) {
    return year >= 1380;
  }

  public boolean validateDate(JalaliCalendar date) {
    return validateDay(date.getYear(), date.getMonth(), date.getDay())
            && validateMonth(date.getMonth())
            && validateYear(date.getYear());
  }
}
