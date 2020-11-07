package ir.ac.kntu.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CityControllerTest.class,
        BranchControllerTest.class,
        CustomerControllerTest.class
})
public class ControllerSuitTest {
}
