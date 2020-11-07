package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.model.Sending;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SendingDao implements Dao<Sending> {
  private File db;
  private ObjectMapper mapper;

  public SendingDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\sending.json";
    mapper =  new ObjectMapper();
    db = new File(dbPath);
  }

  @Override
  public void updateItems(List<Sending> items) {
    try {
      mapper.writeValue(db, items);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Sending> getItems() {
    try {
      Sending[] sendingArray = mapper.readValue(db, Sending[].class);
      List<Sending> sendingList = Arrays.asList(sendingArray);
      return sendingList;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Sending getItem(int id) {
    for (Sending sending :
            this.getItems()) {
      if (sending.getId() == id) {
        return sending;
      }
    }
    return null;
  }

  @Override
  public Sending deleteItem(int id) {
    return null;
  }
}
