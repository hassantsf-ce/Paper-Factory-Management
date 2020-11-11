package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.model.Branch;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BranchDao extends Dao<Branch> {
  public BranchDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\branches.json";
    setMapper(new ObjectMapper());
    setDb(new File(dbPath));
  }

  @Override
  public List<Branch> getItems() {
    try {
      Branch[] customersArray = getMapper().readValue(getDb(), Branch[].class);
      List<Branch> sendingList = Arrays.asList(customersArray);
      return sendingList;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Branch getItem(String branchCode) {
    for (Branch branch :
            this.getItems()) {
      if (branch.getCode().equals(branchCode)) {
        return branch;
      }
    }
    return null;
  }

  @Override
  public Branch deleteItem(String branchCode) {
    return null;
  }
}
