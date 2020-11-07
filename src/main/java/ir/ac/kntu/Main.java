package ir.ac.kntu;

import ir.ac.kntu.controller.CustomerController;
import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.model.Customer;
import ir.ac.kntu.util.ScannerWrapper;

public class Main {
  public static void main(String[] args) throws CanNotInstantiateException {
    Customer customer = new CustomerController().create();
    System.out.println(customer);
  }
}
