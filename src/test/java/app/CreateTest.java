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

        Contact contact = new Contact(inputs[0], inputs[1], inputs[2], inputs[3]);
        Create.createContact(inputs, contactBook);

        assertEquals("Ilari", contact.getFirstName(), "Should be: Ilari");
        assertEquals("Silander", contact.getLastName(), "Should be: Silander");
        assertEquals("123456", contact.getPhoneNumber(), "Should be: 123456");
        assertEquals("ilari@mail.se", contact.getEmail(), "Should be: ilari@mail.se");

    }

    @Test
void ContactBookTakesAContactIntoArrayList() {
        Contact contact = new Contact(inputs[0], inputs[1], inputs[2], inputs[3]);
        Create.createContact(inputs, contactBook);

        assertEquals(1, contactBook.getContactBook().size());
        assertTrue(contactBook.getContactBook().contains(contact), "Should be: True");
    }
}