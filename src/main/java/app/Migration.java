package app;

import model.dto.StudentDto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Migration {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("target/classes/student-list.csv");
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] data = line.split(",");

      String studentId = data[0];
      String fullName = data[1];
      String[] nameParts = fullName.split(" ");
      String firstName = nameParts[1];
      String lastName = nameParts[nameParts.length - 1];
      String email = data[2];

      StudentDto student = new StudentDto(studentId, firstName, lastName, email);
      boolean created = service.UserService.create(student);

      if (created) {
        continue;
      } else {
        System.out.println("Failed to create student with ID: " + studentId);
      }
    }

    System.out.println("All students created successfully!");
    scanner.close();
  }
}
