package ir.ac.kntu.controller;

import ir.ac.kntu.dao.CityDao;
import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.model.City;
import ir.ac.kntu.util.ScannerWrapper;
import ir.ac.kntu.util.validation.CityValidation;
import ir.ac.kntu.util.UserInput;

public class CityController implements Controller<City> {
  private UserInput input;
  private CityValidation validator;

  public CityController() {
    this.input = new UserInput();
    validator = new CityValidation();
  }

  @Override
  public City create() throws CanNotInstantiateException {
    System.out.println("-- Create New City --");
    ScannerWrapper.getInstance().getLine();
    try {
      String cityName = input.getLine("name");
      validator.validateString(cityName);
      String cityState = input.getLine("state name");
      validator.validateString(cityState);
      validator.validateCityNameAndStateValidation(cityName, cityState);
      City newCity = new City(cityName, cityState);

      CityDao dao = new CityDao();

      dao.addItem(newCity);
      return newCity;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new CanNotInstantiateException("City");
    }
  }

}

