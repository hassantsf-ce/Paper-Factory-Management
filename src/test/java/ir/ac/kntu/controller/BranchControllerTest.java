package ir.ac.kntu.controller;

import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.model.Branch;
import ir.ac.kntu.model.City;
import ir.ac.kntu.util.ScannerWrapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BranchControllerTest {
  private BranchController controller;

  @Before
  public void setUp() throws Exception {
    controller = new BranchController();
  }

  @Test
  public void createBranchFromConsole() throws CanNotInstantiateException {
    String input = "4356\nNewYork City\nNewYork\n13";
    ScannerWrapper.setIn(input);

    City expectedCity = new City("NewYork City", "NewYork");
    assertEquals(new Branch("4356",expectedCity, 13), controller.create());

    input = "8919\nChicago\nIllinois\n432";
    ScannerWrapper.setIn(input);
    expectedCity = new City("Chicago", "Illinois");
    assertEquals(new Branch("8919",expectedCity, 432), controller.create());
  }

  @Test(expected = CanNotInstantiateException.class)
  public void throwCanNotInstantiateExceptionWhenCodeIsEmpty() throws CanNotInstantiateException {
    String input = "89\nChicago\nIllinois\n432";
    ScannerWrapper.setIn(input);
    controller.create();
  }

  @Test(expected = CanNotInstantiateException.class)
  public void throwCanNotInstantiateExceptionWhenCityIsInvalid() throws CanNotInstantiateException {
    String input = "89\nChicago\nIs\n432";
    ScannerWrapper.setIn(input);
    controller.create();
  }

  @Test(expected = CanNotInstantiateException.class)
  public void throwCanNotInstantiateExceptionWhenPersonnelNumberIsNegative() throws CanNotInstantiateException {
    String input = "8931\nChicago\nIllinois\n-21";
    ScannerWrapper.setIn(input);
    controller.create();
  }
}