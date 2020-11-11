package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.exceptions.ItemNotFoundException;
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
  public List<Customer> getItems() throws ItemNotFoundException {
    try {
      Customer[] customersArray = getMapper().readValue(getDb(), Customer[].class);
      List<Customer> customersList = Arrays.asList(customersArray);
      if (customersList.isEmpty()) {
        throw new ItemNotFoundException("There is no customer!");
      } else {
        return customersList;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Customer getItem(String nationalNumber) throws ItemNotFoundException {
    Customer result = null;
    for (Customer customer :
            this.getItems()) {
      if (customer.getNationalNumber().equals(nationalNumber)) {
        result = customer;
      }
    }

    if (result == null) {
      throw new ItemNotFoundException("There is no customer with " + nationalNumber + " number");
    } else {
      return result;
    }
  }

  @Override
  public Customer deleteItem(String nationalNumber) {
    return null;
  }
}
