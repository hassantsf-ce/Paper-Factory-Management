package ir.ac.kntu.model;

import ir.ac.kntu.util.JalaliCalendar;

import java.util.Objects;

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
  private SendingMethods methods;

  public Sending(String name, Customer sender, Customer receiver, Branch branch, City origin, City destination, double weight, JalaliCalendar sendTime, JalaliCalendar receiveTime, SendingMethods methods) {
    this.name = name;
    this.sender = sender;
    this.receiver = receiver;
    this.branch = branch;
    this.origin = origin;
    this.destination = destination;
    this.weight = weight;
    this.sendTime = sendTime;
    this.receiveTime = receiveTime;
    this.methods = methods;
  }

  public String getName() {
    return name;
  }

  public Customer getSender() {
    return sender;
  }

  public Customer getReceiver() {
    return receiver;
  }

  public Branch getBranch() {
    return branch;
  }

  public City getOrigin() {
    return origin;
  }

  public City getDestination() {
    return destination;
  }

  public double getWeight() {
    return weight;
  }

  public JalaliCalendar getSendTime() {
    return sendTime;
  }

  public JalaliCalendar getReceiveTime() {
    return receiveTime;
  }

  public SendingMethods getMethods() {
    return methods;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Sending sending = (Sending) o;
    return Double.compare(sending.weight, weight) == 0 &&
            Objects.equals(name, sending.name) &&
            Objects.equals(sender, sending.sender) &&
            Objects.equals(receiver, sending.receiver) &&
            Objects.equals(branch, sending.branch) &&
            Objects.equals(origin, sending.origin) &&
            Objects.equals(destination, sending.destination) &&
            Objects.equals(sendTime, sending.sendTime) &&
            Objects.equals(receiveTime, sending.receiveTime) &&
            Objects.equals(methods, sending.methods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, sender, receiver, branch, origin, destination, weight, sendTime, receiveTime, methods);
  }
}
