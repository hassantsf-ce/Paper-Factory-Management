package ir.ac.kntu.dao;

import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.Customer;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public abstract class DaoTest<T> {
  private Dao<T> dao;
  private String jsonTests[];
  private File jsonTest;

  public void setDao(Dao<T> dao) {
    this.dao = dao;
  }

  public void setJsonTests(String[] jsonTests) {
    this.jsonTests = jsonTests;
  }

  public void setJsonTest(File jsonTest) {
    this.jsonTest = jsonTest;
  }

  public Dao<T> getDao() {
    return dao;
  }

  public File getJsonTest() {
    return jsonTest;
  }

  public String[] getJsonTests() {
    return jsonTests;
  }

  @Before
  public abstract void init();

  protected String getJsonFromFile(String path) {
    try (Scanner scanner = new Scanner(new File(path))) {
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
  public abstract void updateItemsTest();

  @Test
  public abstract void getItemTest() throws ItemNotFoundException;

  @Test
  public abstract void getItemsTest() throws ItemNotFoundException;
}
