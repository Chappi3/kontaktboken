package app;

import domain.Contact;
import domain.ContactBook;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to list all contacts and search
 *
 * @author Hjalmar
 * @since 2018-12-06
 */
public class Lister {

    /**
     * Print all contacts to console
     *
     * @param contactBook Contact book to print
     */
    public static void list(ContactBook contactBook) {
        prettyPrint(contactBook.getContactBook());
    }

    public static void contains(String find, ContactBook contactBook) {
        String findLC = find.toLowerCase();
        List<Contact> contacts = contactBook.getContactBook().stream().filter(c -> c.getFirstName().toLowerCase().contains(findLC)
                || c.getLastName().toLowerCase().contains(findLC)
                || c.getPhoneNumber().toLowerCase().contains(findLC)
                || c.getEmail().toLowerCase().contains(findLC)).collect(Collectors.toList());
        prettyPrint(contacts);

    }

    private static void prettyPrint(List<Contact> contacts) {
        String format = "%-25s %-25s %-25s %-25s" + System.getProperty("line.separator");
        System.out.printf(format, "      First Name", "Last Name", "Phone", "Email");
        int i = 1;
        for (Contact contact : contacts) {
            System.out.printf(format, (i++) + "     " + contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmail());
        }
    }
}
