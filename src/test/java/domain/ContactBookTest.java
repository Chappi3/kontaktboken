package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

    // fields
    private Contact contact = new Contact("Tonny","Frisk","123456","test@mail.com");
    private ContactBook contactBook = new ContactBook();

    // Tests if getContactBook returns right size
    @Test
    void doesContactBookGetRightSize() {
        contactBook.getContactBook().add(contact);
        assertEquals(1, contactBook.getContactBook().size(), "Test failed");
    }

    // checks if the added contact is the same one that is returned
    @Test
    void doesContactBookReturnCorrectContacts() {
        contactBook.getContactBook().add(contact);
        assertTrue(contactBook.getContactBook().contains(contact), "Test failed");
    }
}