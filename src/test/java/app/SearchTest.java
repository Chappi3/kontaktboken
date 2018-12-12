package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchTest {

    //Creates a contact book
    ContactBook contactBook = new ContactBook();

    //Creates a contact with parameters for the test
    Contact contact = new Contact("ilari", "silander","123456", "email@email.se");

    @Test //Checks if the index number 0 is a contact and if it contains (getter) a string "ilari"
    void doesContactBookIndexZeroGetFirstNameContainCorrectName() {
        //Add the contact into the contactbook
        contactBook.getContactBook().add(contact);
        assertTrue(contactBook.getContactBook().get(0).getFirstName().equals("ilari"), "Should contain ilari");
    }

    @Test //Checks if the index number 0 is a contact and if it contains (getter) a string "silander"
    void doesContactBookIndexZeroGetLastNameContainCorrectLastName() {
        contactBook.getContactBook().add(contact);
        assertTrue(contactBook.getContactBook().get(0).getLastName().equals("silander"), "Should contain silander");
    }

    @Test //Checks if the index number 0 is a contact and if it contains (getter) a string "email@email.se"
    void doesContactBookIndexZeroGetEmailNameContainTheCorrectEmail() {
        contactBook.getContactBook().add(contact);
        assertTrue(contactBook.getContactBook().get(0).getEmail().equals("email@email.se"), "Should contain email@email.se");
    }

    @Test //Checks if the index number 0 is a contact and if it contains (getter) a string "123456"
    void doesContactBookIndexZeroGetNumberContainTheCorrectNumber() {
        contactBook.getContactBook().add(contact);
        assertTrue(contactBook.getContactBook().get(0).getPhoneNumber().equals("123456"), "Should contain 123456");
    }
}