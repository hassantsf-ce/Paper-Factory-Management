package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.model.Customer;
import ir.ac.kntu.model.Sending;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CustomerDao implements Dao<Customer> {
  private File db;
  private ObjectMapper mapper;

  public CustomerDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\customers.json";
    mapper = new ObjectMapper();
    db = new File(dbPath);
  }

  @Override
  public void updateItems(List<Customer> items) {
    try {
      mapper.writeValue(db, items);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Customer> getItems() {
    try {
      Customer[] customersArray = mapper.readValue(db, Customer[].class);
      List<Customer> sendingList = Arrays.asList(customersArray);
      return sendingList;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Customer getItem(String nationalNumber) {
    for (Customer sending :
            this.getItems()) {
      if (sending.getNationalNumber().equals(nationalNumber)) {
        return sending;
      }
    }
    return null;
  }

  @Override
  public Customer deleteItem(String nationalNumber) {
    return null;
  }
}
