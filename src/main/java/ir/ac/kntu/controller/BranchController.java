package ir.ac.kntu.controller;

import ir.ac.kntu.model.Branch;
import ir.ac.kntu.model.City;
import ir.ac.kntu.util.UserInput;

public class BranchController implements Controller<Branch> {
  private UserInput input;

  public BranchController() {
    this.input = new UserInput();
  }

  public Branch create() {
    System.out.println("-- Create New Branch --");
    String branchCode = input.getString("branch code");
    return null;
  }
}
