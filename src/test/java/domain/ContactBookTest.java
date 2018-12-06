package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

    private Contact contact = new Contact("Tonny","Frisk","123456","test@mail.com");
    private ContactBook contactBook = new ContactBook();

    @Test
    void getContactBook() {
        contactBook.getContactBook().add(contact);
        assertEquals(1, contactBook.getContactBook().size());
    }
}