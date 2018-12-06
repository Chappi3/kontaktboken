package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class ContactBook implements Serializable {

    // fields
    private ArrayList<Contact> contactBook = new ArrayList<>();
    public static final long serialVersionUID = 748717L;

    // getter
    public ArrayList<Contact> getContactBook() {
        return contactBook;
    }
}
