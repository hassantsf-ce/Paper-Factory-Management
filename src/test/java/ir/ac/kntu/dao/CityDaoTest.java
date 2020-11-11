package ir.ac.kntu.dao;

import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.City;
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

public class CityDaoTest extends DaoTest<City> {
  @Before
  public void init() {
    String[] jsonTests = new String[2];
    jsonTests[0] = "src\\test\\java\\ir\\ac\\kntu\\db\\cities1.json";
    jsonTests[1] = "src\\test\\java\\ir\\ac\\kntu\\db\\cities2.json";
    setJsonTests(jsonTests);
    setDao(new CityDao());
    setJsonTest(new File("src\\test\\java\\ir\\ac\\kntu\\db\\test.json"));
  }

  @Test
  public void updateItemsTest() {
    Dao<City> dao = getDao();
    String[] jsonTests = getJsonTests();
    File jsonTest = getJsonTest();

    City city1 = new City("Qom", "Qom");
    City city2 = new City("Tehran", "Tehran");
    City city3 = new City("Sari", "Mazandaran");
    List<City> cities = new ArrayList<>();
    cities.add(city1);
    cities.add(city2);
    cities.add(city3);
    String expected = getJsonFromFile(jsonTests[0]);
    dao.setDb(jsonTest);
    dao.updateItems(cities);
    String actual = getJsonFromFile(jsonTest.getPath());
    assertEquals(expected, actual);

    // Test 2
    city1 = new City("NewYork City", "NewYork");
    city2 = new City("Los Angles", "California");
    city3 = new City("Chicago", "Illinois");
    cities = new ArrayList<>();
    cities.add(city1);
    cities.add(city2);
    cities.add(city3);
    expected = getJsonFromFile(jsonTests[1]);
    dao.setDb(jsonTest);
    dao.updateItems(cities);
    actual = getJsonFromFile(jsonTest.getPath());
    assertEquals(expected, actual);
  }

  @Test
  public void getItemTest() {
    Dao<City> dao = getDao();
    String[] jsonTests = getJsonTests();

    City expected = new City("Los Angles", "California");
    dao.setDb(new File(jsonTests[1]));
    City actual = null;
    try {
      actual = dao.getItem("Los Angles");
    } catch (ItemNotFoundException e) {
      e.printStackTrace();
    }
    assertEquals(expected, actual);

    // Test 2
    expected = new City("Chicago", "Illinois");
    dao.setDb(new File(jsonTests[1]));
    try {
      actual = dao.getItem("chicago");
    } catch (ItemNotFoundException e) {
      e.printStackTrace();
    }
    // Test for case insensitivity
    assertEquals(expected, actual);

    // Test 3
    expected = new City("Tehran", "Tehran");
    dao.setDb(new File(jsonTests[0]));
    try {
      actual = dao.getItem("Tehran");
    } catch (ItemNotFoundException e) {
      e.printStackTrace();
    }
    assertEquals(expected, actual);
  }

  @Test
  public void getItemsTest() {
    Dao<City> dao = getDao();
    String[] jsonTests = getJsonTests();

    // Test 1
    City city1 = new City("Qom", "Qom");
    City city2 = new City("Tehran", "Tehran");
    ;
    City city3 = new City("Sari", "Mazandaran");
    List<City> expectedCities = new ArrayList<>();
    expectedCities.add(city1);
    expectedCities.add(city2);
    expectedCities.add(city3);

    dao.setDb(new File(jsonTests[0]));
    List<City> actualCities = null;
    try {
      actualCities = dao.getItems();
    } catch (ItemNotFoundException e) {
      e.printStackTrace();
    }
    assertEquals(expectedCities, actualCities);

    // Test 2
    city1 = new City("NewYork City", "NewYork");
    city2 = new City("Los Angles", "California");
    city3 = new City("Chicago", "Illinois");
    expectedCities = new ArrayList<>();
    expectedCities.add(city1);
    expectedCities.add(city2);
    expectedCities.add(city3);

    dao.setDb(new File(jsonTests[1]));
    try {
      actualCities = dao.getItems();
    } catch (ItemNotFoundException e) {
      e.printStackTrace();
    }
    assertEquals(expectedCities, actualCities);
  }
}