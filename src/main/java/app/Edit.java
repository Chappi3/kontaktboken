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
     * This method takes a String[] that contains data to be used to change a contact,
     * it takes a contactBook that we use to get a contact from.
     * This method is used to change a contacts information.
     * The String[] called data contains:
     * data[0] is the contacts index in the contactBook.
     * data[1] is the contacts firstName.
     * data[2] is the contacts lastName.
     * data[3] is the contacts phoneNumber.
     * data[4] is the contacts mail.
     *
     * @param data is a String[] that contains an index, firstName, lastName, phoneNumber and an email.
     * @param contactBook is where we get the contact from, using the index from data[0].
     */

    // Edits a contact
    public static void editContact(String[] data, ContactBook contactBook) {

        Contact contact = null;

        // data contains: 0 = index, 1 = firstName, 2 = lastName, 3 = phoneNumber, 4 = mail

        // contact to be edited
        if (data[0] != null) {
            contact = contactBook.getContactBook().get(Integer.parseInt(data[0]));
        }

        // checks if the input is not null OR input is the same as current firstName variable
        if (data[1] != null || contact != null || !data[1].equals(contact.getFirstName())) {
            // changes the firstName to input
            contact.setFirstName(data[1]);
        }

        // checks if the input is not null OR input is the same as current lastName variable
        if (data[2] != null || contact != null || !data[2].equals(contact.getLastName())) {
            // changes the lastName to input
            contact.setLastName(data[2]);
        }

        // checks if the input is not null OR input is the same as current phoneNumber variable
        if (data[3] != null || contact != null || !data[3].equals(contact.getPhoneNumber())) {
            // changes the phoneNumber to input
            contact.setPhoneNumber(data[3]);
        }

        // checks if the input is not null OR input is the same as current email variable
        if (data[4] != null || contact != null || !data[4].equals(contact.getEmail())) {
            // changes the email to input
            contact.setEmail(data[4]);
        }
    }
}
