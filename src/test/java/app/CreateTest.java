package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ilari Silander
 * @version 1.0
 * @since 2018-12-16
 */

class CreateTest {
    ContactBook contactBook = new ContactBook();
    String[] inputs = {"Ilari", "Silander", "123456", "ilari@mail.se"};

    /**
     * This test checks if the input values from the string array are actually transfered into the contact that
     * is created.
     */

    @Test
    void ContactHasCorrectVariables() {

        Contact contact = new Contact(inputs[0], inputs[1], inputs[2], inputs[3]);
        Create.createContact(inputs, contactBook);

        assertEquals("Ilari", contact.getFirstName(), "Should be: Ilari");
        assertEquals("Silander", contact.getLastName(), "Should be: Silander");
        assertEquals("123456", contact.getPhoneNumber(), "Should be: 123456");
        assertEquals("ilari@mail.se", contact.getEmail(), "Should be: ilari@mail.se");

    }

    /**
     * This test checks that the contactBook only contains ONE object.
     * Then it checks if the object is the very same contact that we created.
     */

    @Test
void ContactBookTakesAContactIntoArrayList() {
        Contact contact = new Contact(inputs[0], inputs[1], inputs[2], inputs[3]);
        Create.createContact(inputs, contactBook);

        assertEquals(1, contactBook.getContactBook().size());
        assertTrue(contactBook.getContactBook().contains(contact), "Should be: True");
    }
}