package ir.ac.kntu.dao;

import ir.ac.kntu.model.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerDaoTest extends DaoTest {
  private Dao<Customer> dao;
  String jsonTests[];
  File jsonTest;


  @Before
  public void init() {
    jsonTests = new String[2];
    jsonTests[0] = "src\\test\\java\\ir\\ac\\kntu\\db\\customers1.json";
    jsonTests[1] = "src\\test\\java\\ir\\ac\\kntu\\db\\customers2.json";
    dao = new CustomerDao();
    jsonTest = new File("src\\test\\java\\ir\\ac\\kntu\\db\\test.json");
  }

  @Test
  public void updateItemsTest() {
    // Test 1
    Customer customer1 = new Customer("Hassan", "3132934138");
    Customer customer2 = new Customer("Ali", "0392358441");
    Customer customer3 = new Customer("Sara", "0838753211");
    List<Customer> customers = new ArrayList<>();
    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);
    String expected = getJsonFromFile(jsonTests[0]);
    dao.setDb(jsonTest);
    dao.updateItems(customers);
    String actual = getJsonFromFile(jsonTest.getPath());
    assertEquals(expected, actual);

    // Test 2
    customer1 = new Customer("John", "0932121365");
    customer2 = new Customer("Jill", "0092358441");
    customer3 = new Customer("Mark", "238753211");
    customers = new ArrayList<>();
    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);
    expected = getJsonFromFile(jsonTests[1]);
    dao.setDb(jsonTest);
    dao.updateItems(customers);
    actual = getJsonFromFile(jsonTest.getPath());
    assertEquals(expected, actual);
  }

  @Test
  public void getItemTest() {
    Customer expected = new Customer("Ali", "0392358441");
    dao.setDb(new File(jsonTests[0]));
    Customer actual = dao.getItem("0392358441");
    assertEquals(expected, actual);

    // Test 2
    expected = new Customer("Sara", "0838753211");
    dao.setDb(new File(jsonTests[0]));
    actual = dao.getItem("0838753211");
    // Test for case insensitivity
    assertEquals(expected, actual);

    // Test 3
    expected = new Customer("Jill", "0092358441");
    dao.setDb(new File(jsonTests[1]));
    actual = dao.getItem("0092358441");
    assertEquals(expected, actual);
  }

  @Test
  public void getItemsTest() {
    // Test 1
    Customer customer1 = new Customer("Hassan", "3132934138");
    Customer customer2 = new Customer("Ali", "0392358441");
    Customer customer3 = new Customer("Sara", "0838753211");
    List<Customer> expectedCities = new ArrayList<>();
    expectedCities.add(customer1);
    expectedCities.add(customer2);
    expectedCities.add(customer3);

    dao.setDb(new File(jsonTests[0]));
    List<Customer> actualCities = dao.getItems();
    assertEquals(expectedCities, actualCities);

    // Test 2
    customer1 = new Customer("John", "0932121365");
    customer2 = new Customer("Jill", "0092358441");
    customer3 = new Customer("Mark", "238753211");
    expectedCities = new ArrayList<>();
    expectedCities.add(customer1);
    expectedCities.add(customer2);
    expectedCities.add(customer3);

    dao.setDb(new File(jsonTests[1]));
    actualCities = dao.getItems();
    assertEquals(expectedCities, actualCities);
  }
}