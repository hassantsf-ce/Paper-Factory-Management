package ir.ac.kntu.model;

import ir.ac.kntu.enums.PostType;
import ir.ac.kntu.enums.SendMethod;
import ir.ac.kntu.enums.SendingStatus;

public class SendingMethods {
  private PostType type;
  private SendMethod method;
  private SendingStatus status;

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

  @Override
  public String toString() {
    return "{" +
            "\n\ttype = " + type +
            "\n\tmethod = " + method +
            "\n\tstatus = " + status +
            "\n}";
  }
}
