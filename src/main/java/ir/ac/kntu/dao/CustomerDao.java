package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.model.Customer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CustomerDao extends Dao<Customer> {
  public CustomerDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\customers.json";
    setMapper(new ObjectMapper());
    setDb(new File(dbPath));
  }

  @Override
  public List<Customer> getItems() {
    try {
      Customer[] customersArray = getMapper().readValue(getDb(), Customer[].class);
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
