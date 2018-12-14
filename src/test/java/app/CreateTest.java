package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateTest {
    ContactBook contactBook = new ContactBook();
    String[] inputs = {"Ilari", "Silander", "123456", "ilari@mail.se"};

    @Test
    void ContactHasCorrectVariables() {

        Create.createContact(inputs, contactBook);

        Contact contact = new Contact(inputs[0], inputs[1], inputs[2], inputs[3]);

        assertEquals("Ilari", contact.getFirstName());
        assertEquals("Silander", contact.getLastName());
        assertEquals("123456", contact.getPhoneNumber());
        assertEquals("ilari@mail.se", contact.getEmail());

    }

    @Test
    void ContactBookTakesAContactIntoArrayList() {

        Create.createContact(inputs, contactBook);

        Contact contact = new Contact(inputs[0], inputs[1], inputs[2], inputs[3]);
        contactBook.getContactBook().add(contact);

        assertTrue(contactBook.getContactBook().contains(contact));
    }
}