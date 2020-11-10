package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.model.Branch;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BranchDao implements Dao<Branch> {
  private File db;
  private ObjectMapper mapper;

  public BranchDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\branches.json";
    mapper = new ObjectMapper();
    db = new File(dbPath);
  }

  @Override
  public void updateItems(List<Branch> items) {
    try {
      mapper.writeValue(db, items);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Branch> getItems() {
    try {
      Branch[] customersArray = mapper.readValue(db, Branch[].class);
      List<Branch> sendingList = Arrays.asList(customersArray);
      return sendingList;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Branch getItem(String branchCode) {
    for (Branch sending :
            this.getItems()) {
      if (sending.getCode().equals(branchCode)) {
        return sending;
      }
    }
    return null;
  }

  @Override
  public Branch deleteItem(String branchCode) {
    return null;
  }
}
