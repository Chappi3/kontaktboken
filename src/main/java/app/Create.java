package app;
import domain.Contact;
import domain.ContactBook;

/**
 * Class to create a contact and then send it to contactBook
 *
 * @author Ilari Silander
 * @version 1.0
 * @since 2018-12-12
 */

public class Create {

    /**
     * This method takes input from the menu class and creates a contact based on the
     * values. Then we store the contact in the contactBook.
     *
     * @param contactBook The parameter where we store the contact
     */
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
