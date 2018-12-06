package app;
import domain.Contact;
import domain.ContactBook;
import java.util.Scanner;

public class Create {

    public void createContact(ContactBook contactBook) {

        Scanner sc = new Scanner(System.in);
        System.out.println("First name: ");
        String name = sc.nextLine();

        System.out.println("Last name: ");
        String lastName = sc.nextLine();

        System.out.println("Phone number: ");
        String phone = sc.nextLine();

        System.out.println("Email: ");
        String mail = sc.nextLine();

        Contact contact = new Contact(name, lastName, phone, mail);
        contactBook.getContactBook().add(contact);
    }
}
