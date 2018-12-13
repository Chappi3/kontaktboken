package app;

import domain.ContactBook;

/**
 * Class for removing a contact from a contactBook
 *
 * @author Tonny Frisk
 * @since 2018-12-12
 */

public class Delete {

    /**
     * This method takes a contactBook that we send to deleteMenu.
     * deleteMenu returns an index that will be removed from contactBook.
     *
     * @param contactBook The parameter where we remove a contact from.
     */
    // for removing a contact from the contactBook
    public static void deleteContact(ContactBook contactBook) {
        Menu menu = new Menu();
        int index;

        // gets index from deleteMenu
        index = menu.deleteMenu(contactBook);

        // removes contact at index
        contactBook.getContactBook().remove(index);
    }
}
