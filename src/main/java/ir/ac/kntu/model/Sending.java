package ir.ac.kntu.model;

import ir.ac.kntu.model.Branch;
import ir.ac.kntu.model.City;
import ir.ac.kntu.model.Customer;
import ir.ac.kntu.util.JalaliCalendar;

public class Sending {
  private String name;
  private Customer sender;
  private Customer receiver;
  private Branch branch;
  private City origin;
  private City destination;
  private double weight;
  private JalaliCalendar sendTime;
  private JalaliCalendar receiveTime;


}
