package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.model.City;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CityDao extends Dao<City> {
  public CityDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\city.json";
    setMapper(new ObjectMapper());
    setDb(new File(dbPath));
  }

  @Override
  public List<City> getItems() {
    try {
      City[] citiesArray = getMapper().readValue(getDb(), City[].class);
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
