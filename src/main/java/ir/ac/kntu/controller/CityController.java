package ir.ac.kntu.controller;

import ir.ac.kntu.dao.CityDao;
import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.model.City;
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
    String cityName = input.getLine("name");
    String cityState = input.getLine("state name");
    try {
      validator.validateString(cityName);
      validator.validateString(cityState);
      validator.validateCityNameAndStateValidation(cityName, cityState);
      City newCity = new City(cityName, cityState);

      CityDao dao = new CityDao();

      dao.addItem(newCity);
      return newCity;
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
//      throw new CanNotInstantiateException("City");
    }

    return null;
  }

}

