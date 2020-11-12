package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.Branch;
import ir.ac.kntu.model.Sending;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SendingDao extends Dao<Sending> {
  public SendingDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\sending.json";
    setMapper(new ObjectMapper());
    setDb(new File(dbPath));
  }

  @Override
  public void addItem(Sending newItem) {
    List<Sending> sending;
    try {
      sending = new ArrayList<>(getItems());
      sending.add(newItem);
    } catch (ItemNotFoundException e) {
      sending = new ArrayList<>();
      sending.add(newItem);
    }

    updateItems(sending);
  }

  @Override
  public List<Sending> getItems() throws ItemNotFoundException {
    try {
      Sending[] sendingArray = getMapper().readValue(getDb(), Sending[].class);
      List<Sending> sendingList = Arrays.asList(sendingArray);
      if (sendingList.isEmpty()) {
        throw new ItemNotFoundException("There is no sending!");
      } else {
        return sendingList;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Sending getItem(String stringId) throws ItemNotFoundException {
    Sending result = null;
    int id = Integer.parseInt(stringId);
    for (Sending sending :
            this.getItems()) {
      if (sending.getId() == id) {
        result = sending;
      }
    }
    if (result == null) {
      throw new ItemNotFoundException("There is no sending with " + id + " name");
    } else {
      return result;
    }
  }

  @Override
  public Sending deleteItem(String stringId) {
    return null;
  }
}
