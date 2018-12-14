package domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class for saving all contacts.
 *
 * @author Tonny Frisk
 * @since 2018-12-6
 */

public class ContactBook implements Serializable {

    // fields
    private ArrayList<Contact> contactBook = new ArrayList<>();
    public static final long serialVersionUID = 748717L;

    /**
     * This is a getter used to get, add or remove contacts from.
     *
     * @return contactBook ArrayList
     */
    // getter
    public ArrayList<Contact> getContactBook() {
        return contactBook;
    }
}
