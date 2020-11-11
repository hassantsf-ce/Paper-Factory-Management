package ir.ac.kntu.view;

import ir.ac.kntu.model.Sending;

import java.awt.Desktop;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class GenerateTable {
  private File view;
  private File template;
  private Scanner scanner;
  private RandomAccessFile writer;

  public GenerateTable() throws IOException {
    view = new File("src\\main\\java\\ir\\ac\\kntu\\view\\view.html");
    template = new File("src\\main\\java\\ir\\ac\\kntu\\view\\template.html");
    this.scanner = new Scanner(template);
    this.writer = new RandomAccessFile(view, "rw");
  }

  private String readHtml() {
    StringBuilder result = new StringBuilder();
    while (scanner.hasNextLine()) {
      result.append(scanner.nextLine());
    }

    return result.toString();
  }

  public void writeSendingTable(List<Sending> sending) {
    StringBuilder builder = new StringBuilder();
    sending.forEach(sendingItem -> {
      builder.append(sendingItem.generateHtml());
    });
    String template = readHtml();
    template = template.replace("%{Insert_Here}%", builder);
    try {
      writer.writeBytes(template);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showHtml() {
    try {
      Desktop.getDesktop().open(view);
    } catch (IOException e) {
      System.out.println("Can not open html file");
    } finally {
      System.out.println("You can view it manually here: ");
      System.out.println(view.getAbsolutePath());
    }
  }
}
