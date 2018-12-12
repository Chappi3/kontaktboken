package app;

import domain.ContactBook;

public class Delete {

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
