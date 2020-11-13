package ir.ac.kntu.controller;

import ir.ac.kntu.dao.CustomerDao;
import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.Customer;
import ir.ac.kntu.util.ScannerWrapper;
import ir.ac.kntu.util.UserInput;
import ir.ac.kntu.util.validation.CustomerValidation;

public class CustomerController implements Controller<Customer> {
  private UserInput input;
  private CustomerValidation validator;
  CustomerDao dao;

  public CustomerController() {
    this.input = new UserInput();
    validator = new CustomerValidation();
    dao = new CustomerDao();
  }

  @Override
  public Customer create() throws CanNotInstantiateException {
    System.out.println("-- Create New Customer --");
    ScannerWrapper.getInstance().getLine();
    try {
      String customerName = input.getLine("name");
      validator.validateString(customerName);
      validator.validateCustomerName(customerName);

      String customerNationalNumber = input.getLine("national number");
      validator.validateString(customerNationalNumber);
      validator.validateNationalNumber(customerNationalNumber);
      Customer newCustomer = new Customer(customerName, customerNationalNumber);
      dao.addItem(newCustomer);
      return newCustomer;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new CanNotInstantiateException("City");
    }
  }

  public Customer getCustomerByNationalNumber(String nationalNumber) throws ItemNotFoundException {
    return dao.getItem(nationalNumber);
  }

  public Customer getCustomerByName(String name) throws ItemNotFoundException {
    for (Customer customer : dao.getItems()) {
      if (customer.getName().toLowerCase().equalsIgnoreCase(name)) {
        return customer;
      }
    }

    throw new ItemNotFoundException("customer");
  }
}