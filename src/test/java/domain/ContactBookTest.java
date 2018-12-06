package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

    // fields
    private Contact contact = new Contact("Tonny","Frisk","123456","test@mail.com");
    private ContactBook contactBook = new ContactBook();

    // Tests if getContactBook returns correctly
    @Test
    void getContactBook() {
        contactBook.getContactBook().add(contact);
        assertEquals(1, contactBook.getContactBook().size());
    }
}