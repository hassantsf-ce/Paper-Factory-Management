package ir.ac.kntu.controller;

import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.model.City;
import ir.ac.kntu.model.Customer;
import ir.ac.kntu.model.Sending;
import ir.ac.kntu.util.UserInput;
import ir.ac.kntu.util.validation.CityValidation;
import ir.ac.kntu.util.validation.SendingValidation;

public class SendingController implements Controller<Sending> {
  private UserInput input;
  private SendingValidation validator;

  public SendingController() {
    this.input = new UserInput();
    validator = new SendingValidation();
  }

  @Override
  public Sending create() throws CanNotInstantiateException {
    CustomerController customerController = new CustomerController();

    System.out.println("-- Create New Sending --");
    String sendingName = input.getLine("name");
    int senderNationalNumber = input.getInt("sender national number");
    int receiverNationalNumber = input.getInt("receiver national number");

    String branchCode = input.getString("branch code");

    String originCityName = input.getLine("origin city name");
    String destinationCityName = input.getLine("destination city name");

    double sendingWeight = input.getDouble("weight");


//    try {
//      validator.validateString(cityName);
//      validator.validateString(cityState);
//      validator.validateCityNameAndStateValidation(cityName, cityState);
//      return null;
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//      throw new CanNotInstantiateException("City");
//    }

    return null;
  }
}