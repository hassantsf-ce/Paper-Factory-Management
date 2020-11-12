package ir.ac.kntu.controller;

import ir.ac.kntu.dao.BranchDao;
import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.model.Branch;
import ir.ac.kntu.model.City;
import ir.ac.kntu.util.ScannerWrapper;
import ir.ac.kntu.util.UserInput;
import ir.ac.kntu.util.validation.BranchValidation;

public class BranchController implements Controller<Branch> {
  private UserInput input;
  private BranchValidation validator;

  public BranchController() {
    this.input = new UserInput();
    this.validator = new BranchValidation();
  }

  public Branch create() throws CanNotInstantiateException {
    System.out.println("-- Create New Branch --");
    try {
      String branchCode = input.getString("branch code");
      validator.validateBranchCode(branchCode);

      ScannerWrapper.getInstance().getLine();
      CityController cityController = new CityController();
      City branchCity = cityController.create();

      int branchPersonnelNumbers = input.getInt("branch personnel numbers");
      validator.validateNegativeNumber(branchPersonnelNumbers);

      Branch newBranch = new Branch(branchCode, branchCity, branchPersonnelNumbers);

      BranchDao dao = new BranchDao();
      dao.addItem(newBranch);
      return newBranch;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new CanNotInstantiateException("Branch");
    }
  }
}
