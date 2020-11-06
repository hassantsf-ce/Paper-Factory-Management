package ir.ac.kntu;

import ir.ac.kntu.controller.BranchController;
import ir.ac.kntu.exceptions.CanNotInstantiateException;
import ir.ac.kntu.model.Branch;
import ir.ac.kntu.util.validation.CityValidation;

public class Main {
  public static void main(String[] args) throws CanNotInstantiateException {
    Branch branch = new BranchController().create();
    System.out.println(branch);
  }
}
