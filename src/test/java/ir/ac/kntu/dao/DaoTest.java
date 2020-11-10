package ir.ac.kntu.dao;

import ir.ac.kntu.model.Customer;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public abstract class DaoTest {
  private Dao<Customer> dao;
  String jsonTests[];
  File jsonTest;


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
  public abstract void getItemTest();

  @Test
  public abstract void getItemsTest();
}
