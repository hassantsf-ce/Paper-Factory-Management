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

public class CustomerDaoTest extends DaoTest<Customer> {
  @Before
  public void init() {
    String[] jsonTests = new String[2];
    jsonTests[0] = "src\\test\\java\\ir\\ac\\kntu\\db\\customers1.json";
    jsonTests[1] = "src\\test\\java\\ir\\ac\\kntu\\db\\customers2.json";
    setJsonTests(jsonTests);
    setDao(new CustomerDao());
    setJsonTest(new File("src\\test\\java\\ir\\ac\\kntu\\db\\test.json"));
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
    String expected = getJsonFromFile(getJsonTests()[0]);
    getDao().setDb(getJsonTest());
    getDao().updateItems(customers);
    String actual = getJsonFromFile(getJsonTest().getPath());
    assertEquals(expected, actual);

    // Test 2
    customer1 = new Customer("John", "0932121365");
    customer2 = new Customer("Jill", "0092358441");
    customer3 = new Customer("Mark", "238753211");
    customers = new ArrayList<>();
    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);
    expected = getJsonFromFile(getJsonTests()[1]);
    getDao().setDb(getJsonTest());
    getDao().updateItems(customers);
    actual = getJsonFromFile(getJsonTest().getPath());
    assertEquals(expected, actual);
  }

  @Test
  public void getItemTest() {
    Dao<Customer> dao = getDao();
    String[] jsonTests = getJsonTests();

    Customer expected = new Customer("Ali", "0392358441");
    getDao().setDb(new File(jsonTests[0]));
    Customer actual = getDao().getItem("0392358441");
    assertEquals(expected, actual);

    // Test 2
    expected = new Customer("Sara", "0838753211");
    getDao().setDb(new File(jsonTests[0]));
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
    Dao<Customer> dao = getDao();
    String[] jsonTests = getJsonTests();
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