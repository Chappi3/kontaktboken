package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CreateTest {
    ContactBook contactBook = new ContactBook();
    Contact contact;
    String[] inputs;
    String name = "Ilari";
    String lastName = "Silander";
    String number = "123456";
    String email = "ilari@mail.se";


    @Test
    void ContactHasCorrectVariables() {
        inputs[0] = name;
        inputs[1] = lastName;
        inputs[2] = number;
        inputs[3] = email;

        contact = new Contact(inputs[0], inputs[1], inputs[2], inputs[3]);

        assertEquals("Ilari", contact.getFirstName());
        assertEquals("Silander", contact.getLastName());
        assertEquals("123456", contact.getPhoneNumber());
        assertEquals("ilari@mail.se", contact.getEmail());

    }

    @Test
    void ContactBookTakesAContactIntoArrayList() {
        contactBook.getContactBook().add(contact);

        assertEquals(1, contactBook.getContactBook().size());

    }
}