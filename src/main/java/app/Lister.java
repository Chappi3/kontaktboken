package app;

import domain.Contact;
import domain.ContactBook;

/**
 * List all contacts from contactBook
 *
 * @author Hjalmar
 * @since 2018-12-06
 */
public class Lister {

    private ContactBook contactBook;

    /**
     * Constructor
     */
    public Lister(ContactBook contactBook) {
        this.contactBook = contactBook;
    }

    /**
     * Print all contacts to console
     */
    public void list() {
        String format = "%-25s %-25s %-25s %-25s" + System.getProperty("line.separator");
        System.out.printf(format, "      First Name", "Last Name", "Phone", "Email");
        int i = 1;
        for (Contact contact : contactBook.getContactBook()) {
            System.out.printf(format, (i++) + "     " + contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmail());
        }
    }
}
