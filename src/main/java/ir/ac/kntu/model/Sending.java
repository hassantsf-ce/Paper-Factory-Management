package ir.ac.kntu.model;

import ir.ac.kntu.view.ViewAsHtml;

import java.util.Objects;

public class Sending implements ViewAsHtml {
  private int id;
  private String name;
  private Customer sender;
  private Customer receiver;
  private Branch branch;
  private City origin;
  private City destination;
  private double weight;
  private DateModel sendTime;
  private DateModel receiveTime;
  private SendingMethods methods;

  // Default Constructor for jackson
  public Sending() {
  }

  public Sending(int id, String name, Customer sender, Customer receiver, Branch branch, City origin, City destination, double weight, DateModel sendTime, DateModel receiveTime, SendingMethods methods) {
    this.id = id;
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

  public int getId() {
    return id;
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

  public DateModel getSendTime() {
    return sendTime;
  }

  public DateModel getReceiveTime() {
    return receiveTime;
  }

  public SendingMethods getMethods() {
    return methods;
  }

  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSender(Customer sender) {
    this.sender = sender;
  }

  public void setReceiver(Customer receiver) {
    this.receiver = receiver;
  }

  public void setBranch(Branch branch) {
    this.branch = branch;
  }

  public void setOrigin(City origin) {
    this.origin = origin;
  }

  public void setDestination(City destination) {
    this.destination = destination;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public void setSendTime(DateModel sendTime) {
    this.sendTime = sendTime;
  }

  public void setReceiveTime(DateModel receiveTime) {
    this.receiveTime = receiveTime;
  }

  public void setMethods(SendingMethods methods) {
    this.methods = methods;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Sending sending = (Sending) o;
    return id == sending.id &&
            Double.compare(sending.weight, weight) == 0 &&
            Objects.equals(name, sending.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "Sending " + id +
            "\nname: " + name +
            "\nsender: " + sender +
            "\nreceiver: " + receiver +
            "\nbranch: " + branch +
            "\norigin: " + origin +
            "\ndestination: " + destination +
            "\nweight: " + weight +
            "\nsendTime: " + sendTime +
            "\nreceiveTime: " + receiveTime +
            "\nmethods: " + methods;
  }

  @Override
  public String generateHtml() {
    return "<tr><td>" + id + "</td>" +
            "<td>" + name + "</td>" +
            sender.generateHtml() +
            receiver.generateHtml() +
            branch.generateHtml() +
            origin.generateHtml() +
            destination.generateHtml() +
            "<td>" + weight + "Kg</td>" +
            sendTime.generateHtml() +
            receiveTime.generateHtml() +
            methods.generateHtml() + "</tr>";
  }
}
