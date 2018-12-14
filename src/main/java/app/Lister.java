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
     * Print all contacts to System out
     *
     * @param contactBook Contact book to print
     */
    public static void list(ContactBook contactBook) {
        prettyPrint(contactBook.getContactBook());
    }

    /**
     * Print all contacts that contains the search parameter to System out
     * Case insensitive
     *
     * @param search      String to match
     * @param contactBook Contact book to print
     */
    public static void printContains(String search, ContactBook contactBook) {
        prettyPrint(contains(search, contactBook));
    }


    /**
     * Return all contacts that contains the search parameter
     * Case insensitive
     *
     * @param search      String to match
     * @param contactBook Contact book to search
     * @return Contacts that match
     */
    public static List<Contact> contains(String search, ContactBook contactBook) {
        String lowerCased = search.toLowerCase();
        return contactBook.getContactBook().stream().filter(c -> c.getFirstName().toLowerCase().contains(lowerCased)
                || c.getLastName().toLowerCase().contains(lowerCased)
                || c.getPhoneNumber().toLowerCase().contains(lowerCased)
                || c.getEmail().toLowerCase().contains(lowerCased)).collect(Collectors.toList());
    }

    /**
     * Private helper method that does the printing
     *
     * @param contacts contacts to print
     */
    private static void prettyPrint(List<Contact> contacts) {
        System.out.println("");
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("Empty contact book");
            return;
        }
        String format = "%-6s %-25s %-25s %-25s %-25s" + System.getProperty("line.separator");
        System.out.printf(format, "Nr", "First Name", "Last Name", "Phone", "Email");
        int i = 1;
        for (Contact contact : contacts) {
            System.out.printf(format, (i++), prettyTruncate(contact.getFirstName()), prettyTruncate(contact.getLastName()), contact.getPhoneNumber(), contact.getEmail());
        }
    }

    private static String prettyTruncate(String input) {
        return truncate(input, 25, "...");
    }

    private static String truncate(String input, int length, String suffix) {
        if (input.length() < length)
            return input;
        return input.substring(0, length - suffix.length()).concat(suffix);
    }
}
