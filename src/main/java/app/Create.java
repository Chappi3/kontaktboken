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
    public static void createContact(String[] input, ContactBook contactBook) {

        //Create a new contact and take the inputs from our Array as parameters for the contact
        Contact contact = new Contact(input[0], input[1], input[2],input[3]);

        //Add contact to contactBook
        contactBook.getContactBook().add(contact);
    }
}
