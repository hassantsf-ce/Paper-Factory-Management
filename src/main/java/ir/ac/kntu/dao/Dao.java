package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.exceptions.ItemNotFoundException;

import java.io.File;
import java.io.IOException;
import java.util.List;

abstract class Dao<T> {
  private File db;
  private ObjectMapper mapper;

  public void setDb(File db) {
    this.db = db;
  }

  public void setMapper(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public ObjectMapper getMapper() {
    return mapper;
  }

  public File getDb() {
    return db;
  }

  public void updateItems(List<T> items) {
    try {
      mapper.writeValue(db, items);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  abstract List<T> getItems() throws ItemNotFoundException;
  abstract T getItem(String id) throws ItemNotFoundException;
  abstract T deleteItem(String id);
}
