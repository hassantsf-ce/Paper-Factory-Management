package ir.ac.kntu.dao;

import ir.ac.kntu.enums.PostType;
import ir.ac.kntu.enums.SendMethod;
import ir.ac.kntu.enums.SendingStatus;
import ir.ac.kntu.model.*;
import ir.ac.kntu.util.JalaliCalendar;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SendingDaoTest extends DaoTest<Sending> {
  @Before
  public void init() {
    String[] jsonTests = new String[2];
    jsonTests[0] = "src\\test\\java\\ir\\ac\\kntu\\db\\sending.json";
    setJsonTests(jsonTests);
    setDao(new SendingDao());
    setJsonTest(new File("src\\test\\java\\ir\\ac\\kntu\\db\\test.json"));
  }

  @Test
  public void updateItemsTest() {
    Dao<Sending> dao = getDao();
    String[] jsonTests = getJsonTests();
    File jsonTest = getJsonTest();

    Customer sender = new Customer("Hassan", "3132934138");
    Customer receiver = new Customer("Ali", "0392358441");
    Branch branch = new Branch("1234", new City("Qom", "Qom"), 1200);
    City origin = new City("Qom", "Qom");
    City destination = new City("Tehran", "Tehran");
    JalaliCalendar sendTime = new JalaliCalendar(1399, 8, 14);
    JalaliCalendar receiveTime = new JalaliCalendar(1399, 8, 17);
    SendingMethods methods = new SendingMethods(PostType.ORDINARY, SendMethod.AIR_MAIL, SendingStatus.POSTED);

    Sending sending1 = new Sending(
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
    methods = new SendingMethods(PostType.CERTIFIED, SendMethod.SEA_MAIL, SendingStatus.STORED);

    Sending sending2 = new Sending(
            2, "1984 Book", sender, receiver,
            branch, origin, destination, 0.8,
            sendTime.getModel(), receiveTime.getModel(),
            methods
    );

    List<Sending> sending = new ArrayList<>();
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
    Dao<Sending> dao = getDao();
    String[] jsonTests = getJsonTests();

    // Test 1
    Customer sender = new Customer("Hassan", "3132934138");
    Customer receiver = new Customer("Ali", "0392358441");
    Branch branch = new Branch("1234", new City("Qom", "Qom"), 1200);
    City origin = new City("Qom", "Qom");
    City destination = new City("Tehran", "Tehran");
    JalaliCalendar sendTime = new JalaliCalendar(1399, 8, 14);
    JalaliCalendar receiveTime = new JalaliCalendar(1399, 8, 17);
    SendingMethods methods = new SendingMethods(PostType.ORDINARY, SendMethod.AIR_MAIL, SendingStatus.POSTED);

    Sending expected = new Sending(
            1, "phone", sender, receiver,
            branch, origin, destination, 2.3,
            sendTime.getModel(), receiveTime.getModel(),
            methods
    );
    dao.setDb(new File(jsonTests[0]));
    Sending actual = dao.getItem("1");
    assertEquals(expected, actual);

    // Test 2
    sender = new Customer("Sara", "0838753211");
    receiver = new Customer("Hassan", "3132934138");
    branch = new Branch("9823", new City("Los Angles", "California"), 814);
    origin = new City("NewYork City", "NewYork");
    destination = new City("Los Angles", "California");
    sendTime = new JalaliCalendar(1399, 6, 20);
    receiveTime = new JalaliCalendar(1399, 6, 22);
    methods = new SendingMethods(PostType.CERTIFIED, SendMethod.SEA_MAIL, SendingStatus.STORED);

    expected = new Sending(
            2, "1984 Book", sender, receiver,
            branch, origin, destination, 0.8,
            sendTime.getModel(), receiveTime.getModel(),
            methods
    );
    dao.setDb(new File(jsonTests[0]));
    actual = dao.getItem("2");
    assertEquals(expected, actual);
  }

  @Test
  public void getItemsTest() {
    Dao<Sending> dao = getDao();
    String[] jsonTests = getJsonTests();

    Customer sender = new Customer("Hassan", "3132934138");
    Customer receiver = new Customer("Ali", "0392358441");
    Branch branch = new Branch("1234", new City("Qom", "Qom"), 1200);
    City origin = new City("Qom", "Qom");
    City destination = new City("Tehran", "Tehran");
    JalaliCalendar sendTime = new JalaliCalendar(1399, 8, 14);
    JalaliCalendar receiveTime = new JalaliCalendar(1399, 8, 17);
    SendingMethods methods = new SendingMethods(PostType.ORDINARY, SendMethod.AIR_MAIL, SendingStatus.POSTED);

    Sending sending1 = new Sending(
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
    methods = new SendingMethods(PostType.CERTIFIED, SendMethod.SEA_MAIL, SendingStatus.STORED);

    Sending sending2 = new Sending(
            2, "1984 Book", sender, receiver,
            branch, origin, destination, 0.8,
            sendTime.getModel(), receiveTime.getModel(),
            methods
    );

    List<Sending> expectedSending = new ArrayList<>();
    expectedSending.add(sending1);
    expectedSending.add(sending2);

    dao.setDb(new File(jsonTests[0]));
    List<Sending> actualSending = dao.getItems();
    assertEquals(expectedSending, actualSending);
  }
}