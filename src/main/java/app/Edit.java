package app;

import domain.Contact;
import domain.ContactBook;

/**
 * Class to edit a contact
 *
 * @author Tonny Frisk
 * @since 2018-12-12
 */

public class Edit {

    /**
     * This method takes a contactBook that we send to editMenu to get the inputs to be used.
     * The inputs are returned as an String[] called data.
     * data[0] is the contacts index in the contactBook.
     * data[1] is the contacts firstName.
     * data[2] is the contacts lastName.
     * data[3] is the contacts phoneNumber.
     * data[4] is the contacts mail.
     *
     * @param contactBook Parameter to get a contact from.
     */

    // Edits a contact
    public static void editContact(ContactBook contactBook) {

        String[] data; // 0 = index, 1 = firstName, 2 = lastName, 3 = phoneNumber, 4 = mail
        Menu menu = new Menu();

        // editMenu() returns a String[]
        data = menu.editMenu(contactBook);

        // contact to be edited
        Contact contact = contactBook.getContactBook().get(Integer.parseInt(data[0]));

        // checks if the input is not null OR input is the same as current firstName variable
        if (data[1] != null || !data[1].equals(contact.getFirstName())) {
            // changes the firstName to input
            contact.setFirstName(data[1]);
        }

        // checks if the input is not null OR input is the same as current lastName variable
        if (data[2] != null || !data[2].equals(contact.getLastName())) {
            // changes the lastName to input
            contact.setLastName(data[2]);
        }

        // checks if the input is not null OR input is the same as current phoneNumber variable
        if (data[3] != null || !data[3].equals(contact.getPhoneNumber())) {
            // changes the phoneNumber to input
            contact.setPhoneNumber(data[3]);
        }

        // checks if the input is not null OR input is the same as current email variable
        if (data[4] != null || !data[4].equals(contact.getEmail())) {
            // changes the email to input
            contact.setEmail(data[4]);
        }
    }
}
