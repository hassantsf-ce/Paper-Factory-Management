package ir.ac.kntu.controller;

import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.model.City;
import ir.ac.kntu.util.ScannerWrapper;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class CityControllerTest {
  private CityController controller;

  @Before
  public void setUp() throws Exception {
    controller = new CityController();
  }

  @Test
  public void createCityFromConsole() throws CanNotInstantiateException {
    String input = "NewYork City\nNewYork";
    ScannerWrapper.setIn(input);
    assertEquals(new City("NewYork City", "NewYork"), controller.create());

    input = "Chicago\nIllinois";
    ScannerWrapper.setIn(input);
    assertEquals(new City("Chicago", "Illinois"), controller.create());
  }

  @Test(expected = CanNotInstantiateException.class)
  public void throwCanNotInstantiateExceptionWhenEmptyArgument() throws CanNotInstantiateException {
    String input = "\nTehran";
    ScannerWrapper.setIn(input);
    controller.create();
  }

  @Test(expected = CanNotInstantiateException.class)
  public void throwCanNotInstantiateExceptionWhenCityNameIsShort() throws CanNotInstantiateException {
    String input = "CD\nSome City";
    ScannerWrapper.setIn(input);
    controller.create();
  }

  @Test(expected = CanNotInstantiateException.class)
  public void throwCanNotInstantiateExceptionWhenCityStateIsShort() throws CanNotInstantiateException {
    String input = "Some State\nCD";
    ScannerWrapper.setIn(input);
    System.out.println(controller.create());
  }
}