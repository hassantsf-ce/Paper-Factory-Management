package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.exceptions.ItemNotFoundException;
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
  public List<City> getItems() throws ItemNotFoundException {
    try {
      City[] citiesArray = getMapper().readValue(getDb(), City[].class);
      List<City> citiesList = Arrays.asList(citiesArray);
      if (citiesList.isEmpty()) {
        throw new ItemNotFoundException("There is no city!");
      } else {
        return citiesList;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public City getItem(String cityName) throws ItemNotFoundException {
    City result = null;
    for (City city :
            this.getItems()) {
      boolean condition = city.getName().toLowerCase().equals(cityName.toLowerCase());
      if (condition) {
        result = city;
      }
    }

    if (result == null) {
      throw new ItemNotFoundException("There is no city with " + cityName + " name");
    } else {
      return result;
    }
  }

  @Override
  public City deleteItem(String cityName) {
    return null;
  }
}
