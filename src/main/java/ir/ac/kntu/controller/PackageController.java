package ir.ac.kntu.controller;

import ir.ac.kntu.dao.BranchDao;
import ir.ac.kntu.dao.CityDao;
import ir.ac.kntu.dao.CustomerDao;
import ir.ac.kntu.dao.PackageDao;
import ir.ac.kntu.enums.PostType;
import ir.ac.kntu.enums.SendMethod;
import ir.ac.kntu.enums.PackageStatus;
import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.exceptions.InvalidDateException;
import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.*;
import ir.ac.kntu.model.Package;
import ir.ac.kntu.util.JalaliCalendar;
import ir.ac.kntu.util.ScannerWrapper;
import ir.ac.kntu.util.UserInput;
import ir.ac.kntu.view.GenerateTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class PackageController implements Controller<Package> {
  private UserInput input;
  private PackageDao dao;

  public PackageController() {
    this.input = new UserInput();
    dao = new PackageDao();
  }

  @Override
  public Package create() throws CanNotInstantiateException {
    try {
      CustomerDao customerDao = new CustomerDao();
      BranchDao branchDao = new BranchDao();
      CityDao cityDao = new CityDao();

      System.out.println("-- Create New Package --");
      ScannerWrapper.getInstance().getLine();
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
      PackageMethods methods = new PackageMethods(type, sendMethod, PackageStatus.STORED);
      Package newPackage = new Package(
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

      PackageDao dao = new PackageDao();
      dao.addItem(newPackage);
      return newPackage;
    } catch (ItemNotFoundException | InvalidDateException e) {
      System.out.println(e.getMessage());
      throw new CanNotInstantiateException("Package");
    }
  }

  public void filterPackageByStatus(PackageStatus sendingStatus) throws ItemNotFoundException, IOException {
    ArrayList<Package> results = new ArrayList<>();
    dao.getItems().forEach(sending -> {
      if (sending.getMethods().getStatus().equals(sendingStatus)) {
        results.add(sending);
      }
    });

    GenerateTable generator = new GenerateTable();
    generator.writePackageTable(results);
    generator.showHtml();
  }

  public void getPackagesByCity(String option, String cityName) throws ItemNotFoundException, IOException {
    List<Package> sending = dao.getItems();
    ArrayList<Package> results = new ArrayList<>();

    sending.forEach(s -> {
      if (option.equals("destination") && s.getDestination().getName().equals(cityName)) {
        results.add(s);
      } else if (option.equals("origin") && s.getOrigin().getName().equals(cityName)) {
        results.add(s);
      }
    });

    GenerateTable generator = new GenerateTable();
    generator.writePackageTable(results);
    generator.showHtml();
  }


  public void logAllPackages() {
    GenerateTable generator = null;
    try {
      List<Package> packages = dao.getItems();
      generator = new GenerateTable();
      generator.writePackageTable(packages);
      generator.showHtml();
    } catch (ItemNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void updatePackagesStatus() throws ItemNotFoundException, IOException {
    GregorianCalendar now = new GregorianCalendar();
    PackageDao dao = new PackageDao();

    List<Package> packages = dao.getItems();
    for (Package pack: packages) {
      DateModel model = pack.getSendTime();
      JalaliCalendar sendTime = new JalaliCalendar(
              model.getYear(), model.getMonth(),
              model.getDay()
      );

      model = pack.getReceiveTime();
      JalaliCalendar receiveTime = new JalaliCalendar(
              model.getYear(), model.getMonth(),
              model.getDay()
      );

     if (sendTime.toGregorian().before(now)) {
       pack.setStatus(PackageStatus.POSTED);
     }

      if (receiveTime.toGregorian().before(now)) {
        pack.setStatus(PackageStatus.RECEIVED);
      }
    }

    dao.updateItems(packages);
    GenerateTable generator = new GenerateTable();
    generator.writePackageTable(packages);
    generator.showHtml();
  }
}