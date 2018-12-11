package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CreateTest {
    ContactBook contactBook = new ContactBook();
    Contact contact;
    String name = "ilari";
    String lastName = "silander";
    String phone = "123456";
    String mail = "mail@mail.com";


    @Test
    void ContactHasCorrectVariables() {
        contact = new Contact(name, lastName, phone, mail);

        assertEquals("ilari", contact.getFirstName());
        assertEquals("silander", contact.getLastName());
        assertEquals("123456", contact.getPhoneNumber());
        assertEquals("mail@mail.com", contact.getEmail());
    }

    @Test
    void ContactBookTakesAContactIntoArrayList() {
        contactBook.getContactBook().add(contact);

        assertEquals(1, contactBook.getContactBook().size());

    }
}