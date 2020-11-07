package ir.ac.kntu.controller;

import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.model.City;
import ir.ac.kntu.model.Customer;
import ir.ac.kntu.util.ScannerWrapper;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class CustomerControllerTest {
  private CustomerController controller;

  @Before
  public void setUp() throws Exception {
    controller = new CustomerController();
  }

  @Test
  public void createCustomerFromConsole() throws CanNotInstantiateException {
    String input = "Hassan\n0373139835";
    ScannerWrapper.setIn(input);
    assertEquals(new Customer("Hassan", "0373139835"), controller.create());

    input = "Sara\n0843230213";
    ScannerWrapper.setIn(input);
    assertEquals(new Customer("Sara", "0843230213"), controller.create());
  }

  @Test(expected = CanNotInstantiateException.class)
  public void throwCanNotInstantiateExceptionWhenNationalNumberIsInvalid() throws CanNotInstantiateException {
    // Short length
    String input = "Sara\n0843230";
    ScannerWrapper.setIn(input);
    controller.create();

    // Long Length
    input = "Sara\n084323021321";
    ScannerWrapper.setIn(input);
    controller.create();

    // Contain non-digit letter
    input = "Sara\n08432302 3";
    ScannerWrapper.setIn(input);
    controller.create();

    // Contain non-digit letter
    input = "Sara\n0843b2a213";
    ScannerWrapper.setIn(input);
    controller.create();
  }

  @Test(expected = CanNotInstantiateException.class)
  public void throwCanNotInstantiateExceptionWhenCustomerNameIsShort() throws CanNotInstantiateException {
    String input = "Sr\n0843020213";
    ScannerWrapper.setIn(input);
    controller.create();
  }
}