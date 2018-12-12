package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchTest {

    ContactBook contactBook = new ContactBook();
    Contact contact = new Contact("ilari", "silander","123456", "email@email.se");

    @Test
    void doesContactBookIndexZeroGetFirstNameContainCorrectName() {
        contactBook.getContactBook().add(contact);
        assertTrue(contactBook.getContactBook().get(0).getFirstName().equals("ilari"), "Should contain ilari");
    }

    @Test
    void doesContactBookIndexZeroGetLastNameContainCorrectLastName() {
        contactBook.getContactBook().add(contact);
        assertTrue(contactBook.getContactBook().get(0).getLastName().equals("silander"), "Should contain silander");
    }

    @Test
    void doesContactBookIndexZeroGetEmailNameContainTheCorrectEmail() {
        contactBook.getContactBook().add(contact);
        assertTrue(contactBook.getContactBook().get(0).getEmail().equals("email@email.se"), "Should contain email@email.se");
    }

    @Test
    void doesContactBookIndexZeroGetNumberContainTheCorrectNumber() {
        contactBook.getContactBook().add(contact);
        assertTrue(contactBook.getContactBook().get(0).getPhoneNumber().equals("123456"), "Should contain 123456");
    }
}