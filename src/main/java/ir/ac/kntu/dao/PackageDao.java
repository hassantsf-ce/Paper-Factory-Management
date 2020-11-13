package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.Package;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PackageDao extends Dao<Package> {
  public PackageDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\sending.json";
    setMapper(new ObjectMapper());
    setDb(new File(dbPath));
  }

  @Override
  public void addItem(Package newItem) {
    List<Package> sending;
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
  public List<Package> getItems() throws ItemNotFoundException {
    try {
      Package[] sendingArray = getMapper().readValue(getDb(), Package[].class);
      List<Package> sendingList = Arrays.asList(sendingArray);
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
  public Package getItem(String stringId) throws ItemNotFoundException {
    Package result = null;
    int id = Integer.parseInt(stringId);
    for (Package sending :
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
  public Package deleteItem(String stringId) {
    return null;
  }
}
