package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.model.City;
import ir.ac.kntu.model.Customer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CityDao implements Dao<City> {
  private File db;
  private ObjectMapper mapper;

  public CityDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\city.json";
    mapper = new ObjectMapper();
    db = new File(dbPath);
  }

  @Override
  public void updateItems(List<City> items) {
    try {
      mapper.writeValue(db, items);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<City> getItems() {
    try {
      City[] citiesArray = mapper.readValue(db, City[].class);
      List<City> sendingList = Arrays.asList(citiesArray);
      return sendingList;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public City getItem(String cityName) {
    for (City sending :
            this.getItems()) {
      boolean condition = sending.getName().toLowerCase().equals(cityName.toLowerCase());
      if (condition) {
        return sending;
      }
    }
    return null;
  }

  @Override
  public City deleteItem(String cityName) {
    return null;
  }
}
