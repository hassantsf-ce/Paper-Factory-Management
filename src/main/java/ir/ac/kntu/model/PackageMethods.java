package ir.ac.kntu.model;

import ir.ac.kntu.enums.PostType;
import ir.ac.kntu.enums.SendMethod;
import ir.ac.kntu.enums.PackageStatus;
import ir.ac.kntu.view.ViewAsHtml;

public class PackageMethods implements ViewAsHtml {
  private PostType type;
  private SendMethod method;
  private PackageStatus status;

  // Default Constructor for jackson
  public PackageMethods() {
  }

  public PackageMethods(PostType type, SendMethod method, PackageStatus status) {
    this.type = type;
    this.method = method;
    this.status = status;
  }

  public PostType getType() {
    return type;
  }

  public PackageStatus getStatus() {
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

  public void setStatus(PackageStatus status) {
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

  @Override
  public String generateHtml() {
    return "<td>" + type + "</td>"
            + "<td>" + method + "</td>"
            + "<td>" + status + "</td>";
  }
}
