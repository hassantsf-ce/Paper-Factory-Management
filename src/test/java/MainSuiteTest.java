import ir.ac.kntu.controller.ControllerSuitTest;
import ir.ac.kntu.dao.DaoSuiteTest;
import ir.ac.kntu.dao.DaoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ControllerSuitTest.class,
        DaoSuiteTest.class
})
public class MainSuiteTest {
}
