package ir.ac.kntu;

import ir.ac.kntu.controller.BranchController;
import ir.ac.kntu.controller.CityController;
import ir.ac.kntu.controller.CustomerController;
import ir.ac.kntu.controller.SendingController;
import ir.ac.kntu.dao.BranchDao;
import ir.ac.kntu.dao.CityDao;
import ir.ac.kntu.dao.CustomerDao;
import ir.ac.kntu.dao.SendingDao;
import ir.ac.kntu.enums.SendingStatus;
import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.Customer;
import ir.ac.kntu.util.ScannerWrapper;
import ir.ac.kntu.util.UserInput;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    menu();
  }

  static void menu() {
    CityController cityController = new CityController();
    BranchController branchController = new BranchController();
    CustomerController customerController = new CustomerController();
    SendingController sendingController = new SendingController();

    System.out.println("Post Office");
    System.out.println("Choose from options blow:");
    String[] options = {
            "Add City",
            "Add Customer",
            "Add Branch",
            "Add Sending",
            "Send Package",
            "Log Packages",
            "Log Package with city",
            "Log Customer with name",
            "Log Customer with national number",
            "Filter Packages with status",
            "Exit"
    };

    UserInput input = new UserInput();
    int choice = input.chooseFromList(options);
    while (choice != options.length) {

      try {
        switch (choice) {
          case 1:
            cityController.create();
            break;
          case 2:
            customerController.create();
            break;
          case 3:
            branchController.create();
            break;
          case 4:
            sendingController.create();
            break;
          case 6:
            sendingController.logAllPackages();
            break;

          case 7:
            ScannerWrapper.getInstance().getLine();
            String cityName = input.getLine("city name");
            String[] cityOptions = {"origin", "destination"};
            int cityChoice = input.chooseFromList(cityOptions);
            System.out.println(cityChoice);
            sendingController.getPackagesByCity(cityOptions[cityChoice - 1], cityName);
            break;

          case 8:
            ScannerWrapper.getInstance().getLine();
            String customerName = input.getLine("customer name");
            System.out.println(customerController.getCustomerByName(customerName));
            break;

          case 9:
            ScannerWrapper.getInstance().getLine();
            String customerNationalNumber = input.getLine("customer national number");
            System.out.println(customerController.getCustomerByNationalNumber(customerNationalNumber));
            break;

          case 10:
            int statusChoice = input.chooseFromList(
                    SendingStatus.getStringValues()
            );
            sendingController.filterSendingByStatus(
                    SendingStatus.values()[statusChoice - 1]
            );
            break;
          default:
        }
      } catch (CanNotInstantiateException | ItemNotFoundException e) {
        System.out.println(e.getMessage());
      } catch (IOException e) {
        e.printStackTrace();
      }

      System.out.println("\n");
      choice = input.chooseFromList(options);
    }
  }
}