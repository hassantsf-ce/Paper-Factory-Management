package ir.ac.kntu.controller;

import ir.ac.kntu.dao.BranchDao;
import ir.ac.kntu.dao.CityDao;
import ir.ac.kntu.dao.CustomerDao;
import ir.ac.kntu.enums.PostType;
import ir.ac.kntu.enums.SendMethod;
import ir.ac.kntu.enums.SendingStatus;
import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.*;
import ir.ac.kntu.util.JalaliCalendar;
import ir.ac.kntu.util.ScannerWrapper;
import ir.ac.kntu.util.UserInput;
import ir.ac.kntu.util.validation.CityValidation;
import ir.ac.kntu.util.validation.SendingValidation;

import java.util.Scanner;

public class SendingController implements Controller<Sending> {
  private UserInput input;
  private SendingValidation validator;

  public SendingController() {
    this.input = new UserInput();
    validator = new SendingValidation();
  }

  @Override
  public Sending create() throws CanNotInstantiateException {
    try {
      CustomerDao customerDao = new CustomerDao();
      BranchDao branchDao = new BranchDao();
      CityDao cityDao = new CityDao();

      System.out.println("-- Create New Sending --");
      String sendingName = input.getLine("name");

      String senderNationalNumber = input.getString("sender national number");
      Customer sender = customerDao.getItem(senderNationalNumber);
      String receiverNationalNumber = input.getString("receiver national number");
      Customer receiver = customerDao.getItem(receiverNationalNumber);

      String branchCode = input.getString("branch code");
      Branch branch = branchDao.getItem(branchCode);

      ScannerWrapper.getInstance().getLine();
      String originCityName = input.getLine("origin city name");
      City origin = cityDao.getItem(originCityName);
      String destinationCityName = input.getLine("destination city name");
      City destination = cityDao.getItem(destinationCityName);

      double weight = input.getDouble("weight");

      ScannerWrapper.getInstance().getLine();
      JalaliCalendar sendDate = input.getDate("send date");
      JalaliCalendar receiveDate = input.getDate("receive date");

      int userChoice = input.chooseFromList(PostType.getStringValues());
      PostType type = PostType.values()[userChoice];

      userChoice = input.chooseFromList(SendMethod.getStringValues());
      SendMethod sendMethod = SendMethod.values()[userChoice];
      SendingMethods methods = new SendingMethods(type, sendMethod, SendingStatus.STORED);
      return new Sending(
              sendingName,
              sender,
              receiver,
              branch,
              origin,
              destination,
              weight,
              sendDate.getModel(),
              receiveDate.getModel(),
              methods
      );
    } catch (ItemNotFoundException e) {
      System.out.println(e.getMessage());
      throw new CanNotInstantiateException("Sending");
    }
  }
}