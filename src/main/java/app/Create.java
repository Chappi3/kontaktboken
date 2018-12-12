package app;
import domain.Contact;
import domain.ContactBook;

public class Create {

    public static void createContact(ContactBook contactBook) {
        //Create a new menu object
        Menu menu = new Menu();

        //We put all the inputs (firstName, lastName, phoneNumber, email) from menu.createMenu() into an Array
        String[] data = menu.createMenu();

        //Create a new contact and take the inputs from our Array as parameters for the contact
        Contact contact = new Contact(data[0], data[1], data[2],data[3]);

        //Add contact to contactBook
        contactBook.getContactBook().add(contact);
    }
}
