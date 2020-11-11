package ir.ac.kntu.dao;

import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.Branch;
import ir.ac.kntu.model.City;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BranchDaoTest extends DaoTest<Branch> {
  @Before
  public void init() {
    String[] jsonTests = new String[2];
    jsonTests[0] = "src\\test\\java\\ir\\ac\\kntu\\db\\branches1.json";
    jsonTests[1] = "src\\test\\java\\ir\\ac\\kntu\\db\\branches2.json";
    setJsonTests(jsonTests);
    setDao(new BranchDao());
    setJsonTest(new File("src\\test\\java\\ir\\ac\\kntu\\db\\test.json"));
  }

  @Test
  public void updateItemsTest() {
    Dao<Branch> dao = getDao();
    String[] jsonTests = getJsonTests();
    File jsonTest = getJsonTest();

    City city1 = new City("Qom", "Qom");
    City city2 = new City("Sari", "Mazandaran");
    City city3 = new City("Tehran", "Tehran");

    Branch branch1 = new Branch("1234", city1, 1200);
    Branch branch2 = new Branch("1935", city2, 435);
    Branch branch3 = new Branch("6420", city3, 23);
    List<Branch> branches = new ArrayList<>();
    branches.add(branch1);
    branches.add(branch2);
    branches.add(branch3);
    String expected = getJsonFromFile(jsonTests[0]);
    dao.setDb(jsonTest);
    dao.updateItems(branches);
    String actual = getJsonFromFile(jsonTest.getPath());
    assertEquals(expected, actual);


    // Test 2
    city1 = new City("Tehran", "Varamin");
    city2 = new City("Los Angles", "California");
    city3 = new City("Chicago", "Illinois");

    branch1 = new Branch("3387", city1, 13);
    branch2 = new Branch("9823", city2, 814);
    branch3 = new Branch("9893", city3, 613);
    branches = new ArrayList<>();
    branches.add(branch1);
    branches.add(branch2);
    branches.add(branch3);
    expected = getJsonFromFile(jsonTests[1]);
    dao.setDb(jsonTest);
    dao.updateItems(branches);
    actual = getJsonFromFile(jsonTest.getPath());
    assertEquals(expected, actual);
  }

  @Test
  public void getItemTest() throws ItemNotFoundException {
    Dao<Branch> dao = getDao();
    String[] jsonTests = getJsonTests();

    // Test 1
    Branch expected = new Branch("1234", new City("Qom", "Qom"), 1200);
    dao.setDb(new File(jsonTests[0]));
    Branch actual = dao.getItem("1234");
    assertEquals(expected, actual);

    // Test 2
    expected = new Branch("6420", new City("Tehran", "Tehran"), 23);
    dao.setDb(new File(jsonTests[0]));
    actual = dao.getItem("6420");
    // Test for case insensitivity
    assertEquals(expected, actual);

    // Test 3
    expected = new Branch("9823" ,new City("Los Angles", "California"), 814);
    dao.setDb(new File(jsonTests[1]));
    actual = dao.getItem("9823");
    assertEquals(expected, actual);
  }

  @Test
  public void getItemsTest() throws ItemNotFoundException {
    Dao<Branch> dao = getDao();
    String[] jsonTests = getJsonTests();

    // Test 1
    City city1 = new City("Qom", "Qom");
    City city2 = new City("Sari", "Mazandaran");
    City city3 = new City("Tehran", "Tehran");

    Branch branch1 = new Branch("1234", city1, 1200);
    Branch branch2 = new Branch("1935", city2, 435);
    Branch branch3 = new Branch("6420", city3, 23);
    List<Branch> expectedBranches = new ArrayList<>();
    expectedBranches.add(branch1);
    expectedBranches.add(branch2);
    expectedBranches.add(branch3);

    dao.setDb(new File(jsonTests[0]));
    List<Branch> actualCities = dao.getItems();
    assertEquals(expectedBranches, actualCities);

    // Test 2
    city1 = new City("Tehran", "Varamin");
    city2 = new City("Los Angles", "California");
    city3 = new City("Chicago", "Illinois");

    branch1 = new Branch("3387", city1, 13);
    branch2 = new Branch("9823", city2, 814);
    branch3 = new Branch("9893", city3, 613);
    expectedBranches = new ArrayList<>();
    expectedBranches.add(branch1);
    expectedBranches.add(branch2);
    expectedBranches.add(branch3);

    dao.setDb(new File(jsonTests[1]));
    actualCities = dao.getItems();
    assertEquals(expectedBranches, actualCities);
  }
}