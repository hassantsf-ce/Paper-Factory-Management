package ir.ac.kntu.dao;

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

public class CityDaoTest {
  private Dao<City> dao;
  String jsonTests[];
  File jsonTest;


  @Before
  public void init() {
    jsonTests = new String[2];
    jsonTests[0] = "src\\test\\java\\ir\\ac\\kntu\\db\\cities1.json";
    jsonTests[1] = "src\\test\\java\\ir\\ac\\kntu\\db\\cities2.json";
    dao = new CityDao();
    jsonTest = new File("src\\test\\java\\ir\\ac\\kntu\\db\\test.json");
  }

  private String getJsonFromFile(String path) {
    try (Scanner scanner = new Scanner(new File(path)); RandomAccessFile accessFile = new RandomAccessFile(jsonTest, "rw")) {
      StringBuilder json = new StringBuilder();

      while (scanner.hasNextLine()) {
        json.append(scanner.nextLine());
      }

      return json.toString().replaceAll("\\s", "");
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Test
  public void updateItemsTest() {
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
    City expected = new City("Los Angles", "California");
    dao.setDb(new File(jsonTests[1]));
    City actual = dao.getItem("Los Angles");
    assertEquals(expected, actual);

    // Test 2
    expected = new City("Chicago", "Illinois");
    dao.setDb(new File(jsonTests[1]));
    actual = dao.getItem("chicago");
    // Test for case insensitivity
    assertEquals(expected, actual);

    // Test 3
    expected = new City("Tehran", "Tehran");
    dao.setDb(new File(jsonTests[0]));
    actual = dao.getItem("Tehran");
    assertEquals(expected, actual);
  }

  @Test
  public void getItemsTest() {
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
    List<City> actualCities = dao.getItems();
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
    actualCities = dao.getItems();
    assertEquals(expectedCities, actualCities);
  }
}