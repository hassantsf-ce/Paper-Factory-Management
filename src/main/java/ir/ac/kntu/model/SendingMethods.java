package ir.ac.kntu.model;

import ir.ac.kntu.enums.PostType;
import ir.ac.kntu.enums.SendMethod;
import ir.ac.kntu.enums.SendingStatus;

public class SendingMethods {
  private PostType type;
  private SendMethod method;
  private SendingStatus status;

  // Default Constructor for jackson
  public SendingMethods() {}

  public SendingMethods(PostType type, SendMethod method, SendingStatus status) {
    this.type = type;
    this.method = method;
    this.status = status;
  }

  public PostType getType() {
    return type;
  }

  public SendingStatus getStatus() {
    return status;
  }

  public SendMethod getMethod() {
    return method;
  }

  public void setType(PostType type) {
    this.type = type;
  }

  public void setMethod(SendMethod method) {
    this.method = method;
  }

  public void setStatus(SendingStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "{" +
            "\n\ttype = " + type +
            "\n\tmethod = " + method +
            "\n\tstatus = " + status +
            "\n}";
  }
}
