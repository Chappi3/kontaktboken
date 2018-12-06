package app;
import java.util.Scanner;

public class Create() {
  Scanner sc = new Scanner(System.in);

  Contact contact = new Contact();

  System.out.println("Enter first name: ");
  contact.setFirstName(sc.nextLine());

  System.out.println("Enter last name: ");
  contact.setLastName(sc.nextLine());
  System.out.println("Enter phone number: ");
  contact.setPhoneNumber(sc.nextInt());
  System.out.println("Enter email: ");
  contact.setEmail(sc.nextLine());

}
