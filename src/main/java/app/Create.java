package app;
import domain.Contact;
import domain.ContactBook;

public class Create {

    public static void createContact(ContactBook contactBook) {
        Menu menu = new Menu();
        String[] data = menu.createMenu();//firstName, lastName, phoneNumber, email

        Contact contact = new Contact(data[0], data[1], data[2],data[3]);
        contactBook.getContactBook().add(contact);
    }
}
