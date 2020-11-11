package ir.ac.kntu.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CityDaoTest.class,
        CustomerDaoTest.class,
        BranchDaoTest.class,
        SendingDaoTest.class
})
public class DaoSuiteTest {
}
