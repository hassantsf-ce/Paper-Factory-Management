package ir.ac.kntu.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.Branch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchDao extends Dao<Branch> {
  public BranchDao() {
    String dbPath = "src\\main\\java\\ir\\ac\\kntu\\db\\branches.json";
    setMapper(new ObjectMapper());
    setDb(new File(dbPath));
  }

  @Override
  public void addItem(Branch newItem) {
    List<Branch> branches;
    try {
      branches = new ArrayList<>(getItems());
      branches.add(newItem);
    } catch (ItemNotFoundException e) {
      branches = new ArrayList<>();
      branches.add(newItem);
    }

    updateItems(branches);
  }

  @Override
  public List<Branch> getItems() throws ItemNotFoundException {
    try {
      Branch[] customersArray = getMapper().readValue(getDb(), Branch[].class);
      List<Branch> branchesList = Arrays.asList(customersArray);
      if (branchesList.isEmpty()) {
        throw new ItemNotFoundException("There is no branch!");
      } else {
        return branchesList;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Branch getItem(String branchCode) throws ItemNotFoundException {
    Branch result = null;
    for (Branch branch :
            this.getItems()) {
      if (branch.getCode().equals(branchCode)) {
        result = branch;
      }
    }

    if (result == null) {
      throw new ItemNotFoundException("There is no branch with " + branchCode + " code");
    } else {
      return result;
    }
  }

  @Override
  public Branch deleteItem(String branchCode) {
    return null;
  }
}
