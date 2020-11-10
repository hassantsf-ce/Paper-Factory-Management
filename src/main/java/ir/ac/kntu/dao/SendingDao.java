package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.model.Sending;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SendingDao extends Dao<Sending> {
  public SendingDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\sending.json";
    setMapper(new ObjectMapper());
    setDb(new File(dbPath));
  }

  @Override
  public List<Sending> getItems() {
    try {
      Sending[] sendingArray = getMapper().readValue(getDb(), Sending[].class);
      List<Sending> sendingList = Arrays.asList(sendingArray);
      return sendingList;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Sending getItem(String stringId) {
    int id = Integer.parseInt(stringId);
    for (Sending sending :
            this.getItems()) {
      if (sending.getId() == id) {
        return sending;
      }
    }
    return null;
  }

  @Override
  public Sending deleteItem(String stringId) {
    return null;
  }
}
