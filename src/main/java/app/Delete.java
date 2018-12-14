package app;

import domain.ContactBook;

/**
 * Class for removing a contact from a contactBook.
 *
 * @author Tonny Frisk
 * @since 2018-12-12
 */

public class Delete {

    /**
     * Removes a contact from a contactBook.
     *
     * @param index is the contacts index in the contactBook.
     * @param contactBook is where the contact will be removed from.
     */
    // for removing a contact from the contactBook
    public static void deleteContact(int index, ContactBook contactBook) {

        // removes contact at index
        contactBook.getContactBook().remove(index);
    }
}
