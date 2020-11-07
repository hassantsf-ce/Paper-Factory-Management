package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.dao.Dao;
import ir.ac.kntu.model.Sending;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SendingDao implements Dao<Sending> {
  private final String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\sending.json";
  private File db;

  public SendingDao() {
    db = new File(dbPath);
  }

  @Override
  public void updateItems(ArrayList<Sending> items) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      mapper.writeValue(db, items);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public ArrayList<Sending> getItems() {
    return null;
  }

  @Override
  public Sending getItem(int id) {
    return null;
  }

  @Override
  public Sending deleteItem(int id) {
    return null;
  }
}
