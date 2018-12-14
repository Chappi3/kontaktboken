package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteTest {

    // creates a new contactBook
    private ContactBook contactBook = new ContactBook();

    // creates a new contact
    private Contact contact = new Contact("test", "person" , "1", "mail@mail");

    // checks if a contact is removed correctly
    @Test
    void doesContactGetRemovedCorrectly() {
        int index = 0;
        contactBook.getContactBook().add(contact);
        contactBook.getContactBook().add(contact);
        Delete.deleteContact(index, contactBook);
        assertEquals(1, contactBook.getContactBook().size(), "Test failed");
    }
}