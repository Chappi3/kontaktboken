package util;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FakeContactsTest {

    @Test
    void createContacts() {
        int size = 100;


        List<Contact> contacts = FakeContacts.createContacts(size);
        assertEquals(size, contacts.size());
        ContactBook contactBook = new ContactBook();
        contactBook.getContactBook().addAll(contacts);

        assertTrue(FakeContacts.lines("asdadasdads").isEmpty());

        ContactBook book = FakeContacts.createBook(size);
        assertEquals(size, book.getContactBook().size());


    }
}