package ir.ac.kntu.dao;

import ir.ac.kntu.enums.PackageStatus;
import ir.ac.kntu.enums.PostType;
import ir.ac.kntu.enums.SendMethod;
import ir.ac.kntu.exceptions.ItemNotFoundException;
import ir.ac.kntu.model.*;
import ir.ac.kntu.model.Package;
import ir.ac.kntu.util.JalaliCalendar;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PackageDaoTest extends DaoTest<Package> {
  @Before
  public void init() {
    String[] jsonTests = new String[2];
    jsonTests[0] = "src\\test\\java\\ir\\ac\\kntu\\db\\sending.json";
    setJsonTests(jsonTests);
    setDao(new PackageDao());
    setJsonTest(new File("src\\test\\java\\ir\\ac\\kntu\\db\\test.json"));
  }

  @Test
  public void updateItemsTest() {
    Dao<Package> dao = getDao();
    String[] jsonTests = getJsonTests();
    File jsonTest = getJsonTest();

    Customer sender = new Customer("Hassan", "3132934138");
    Customer receiver = new Customer("Ali", "0392358441");
    Branch branch = new Branch("1234", new City("Qom", "Qom"), 1200);
    City origin = new City("Qom", "Qom");
    City destination = new City("Tehran", "Tehran");
    JalaliCalendar sendTime = new JalaliCalendar(1399, 8, 14);
    JalaliCalendar receiveTime = new JalaliCalendar(1399, 8, 17);
    PackageMethods methods = new PackageMethods(PostType.ORDINARY, SendMethod.AIR_MAIL, PackageStatus.POSTED);

    Package sending1 = new Package(
            1, "phone", sender, receiver,
            branch, origin, destination, 2.3,
            sendTime.getModel(), receiveTime.getModel(),
            methods
    );

    sender = new Customer("Sara", "0838753211");
    receiver = new Customer("Hassan", "3132934138");
    branch = new Branch("9823", new City("Los Angles", "California"), 814);
    origin = new City("NewYork City", "NewYork");
    destination = new City("Los Angles", "California");
    sendTime = new JalaliCalendar(1399, 6, 20);
    receiveTime = new JalaliCalendar(1399, 6, 22);
    methods = new PackageMethods(PostType.CERTIFIED, SendMethod.SEA_MAIL, PackageStatus.STORED);

    Package sending2 = new Package(
            2, "1984 Book", sender, receiver,
            branch, origin, destination, 0.8,
            sendTime.getModel(), receiveTime.getModel(),
            methods
    );

    List<Package> sending = new ArrayList<>();
    sending.add(sending1);
    sending.add(sending2);
    String expected = getJsonFromFile(jsonTests[0]);
    dao.setDb(jsonTest);
    dao.updateItems(sending);
    String actual = getJsonFromFile(jsonTest.getPath());
    assertEquals(expected, actual);
  }

  @Test
  public void getItemTest() {
    Dao<Package> dao = getDao();
    String[] jsonTests = getJsonTests();

    // Test 1
    Customer sender = new Customer("Hassan", "3132934138");
    Customer receiver = new Customer("Ali", "0392358441");
    Branch branch = new Branch("1234", new City("Qom", "Qom"), 1200);
    City origin = new City("Qom", "Qom");
    City destination = new City("Tehran", "Tehran");
    JalaliCalendar sendTime = new JalaliCalendar(1399, 8, 14);
    JalaliCalendar receiveTime = new JalaliCalendar(1399, 8, 17);
    PackageMethods methods = new PackageMethods(PostType.ORDINARY, SendMethod.AIR_MAIL, PackageStatus.POSTED);

    Package expected = new Package(
            1, "phone", sender, receiver,
            branch, origin, destination, 2.3,
            sendTime.getModel(), receiveTime.getModel(),
            methods
    );
    dao.setDb(new File(jsonTests[0]));
    Package actual = null;
    try {
      actual = dao.getItem("1");
    } catch (ItemNotFoundException e) {
      e.printStackTrace();
    }
    assertEquals(expected, actual);

    // Test 2
    sender = new Customer("Sara", "0838753211");
    receiver = new Customer("Hassan", "3132934138");
    branch = new Branch("9823", new City("Los Angles", "California"), 814);
    origin = new City("NewYork City", "NewYork");
    destination = new City("Los Angles", "California");
    sendTime = new JalaliCalendar(1399, 6, 20);
    receiveTime = new JalaliCalendar(1399, 6, 22);
    methods = new PackageMethods(PostType.CERTIFIED, SendMethod.SEA_MAIL, PackageStatus.STORED);

    expected = new Package(
            2, "1984 Book", sender, receiver,
            branch, origin, destination, 0.8,
            sendTime.getModel(), receiveTime.getModel(),
            methods
    );
    dao.setDb(new File(jsonTests[0]));
    try {
      actual = dao.getItem("2");
    } catch (ItemNotFoundException e) {
      e.printStackTrace();
    }
    assertEquals(expected, actual);
  }

  @Test
  public void getItemsTest() {
    Dao<Package> dao = getDao();
    String[] jsonTests = getJsonTests();

    Customer sender = new Customer("Hassan", "3132934138");
    Customer receiver = new Customer("Ali", "0392358441");
    Branch branch = new Branch("1234", new City("Qom", "Qom"), 1200);
    City origin = new City("Qom", "Qom");
    City destination = new City("Tehran", "Tehran");
    JalaliCalendar sendTime = new JalaliCalendar(1399, 8, 14);
    JalaliCalendar receiveTime = new JalaliCalendar(1399, 8, 17);
    PackageMethods methods = new PackageMethods(PostType.ORDINARY, SendMethod.AIR_MAIL, PackageStatus.POSTED);

    Package sending1 = new Package(
            1, "phone", sender, receiver,
            branch, origin, destination, 2.3,
            sendTime.getModel(), receiveTime.getModel(),
            methods
    );

    sender = new Customer("Sara", "0838753211");
    receiver = new Customer("Hassan", "3132934138");
    branch = new Branch("9823", new City("Los Angles", "California"), 814);
    origin = new City("NewYork City", "NewYork");
    destination = new City("Los Angles", "California");
    sendTime = new JalaliCalendar(1399, 6, 20);
    receiveTime = new JalaliCalendar(1399, 6, 22);
    methods = new PackageMethods(PostType.CERTIFIED, SendMethod.SEA_MAIL, PackageStatus.STORED);

    Package sending2 = new Package(
            2, "1984 Book", sender, receiver,
            branch, origin, destination, 0.8,
            sendTime.getModel(), receiveTime.getModel(),
            methods
    );

    List<Package> expectedPackage = new ArrayList<>();
    expectedPackage.add(sending1);
    expectedPackage.add(sending2);

    dao.setDb(new File(jsonTests[0]));
    List<Package> actualPackage = null;
    try {
      actualPackage = dao.getItems();
    } catch (ItemNotFoundException e) {
      e.printStackTrace();
    }
    assertEquals(expectedPackage, actualPackage);
  }
}