package ir.ac.kntu.controller;

import ir.ac.kntu.controller.BranchControllerTest;
import ir.ac.kntu.controller.CityControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CityControllerTest.class,
        BranchControllerTest.class
})
public class ControllerSuitTest {
}
