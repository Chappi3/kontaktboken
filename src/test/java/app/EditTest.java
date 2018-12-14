package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditTest {

    // creates a contactBook
    private ContactBook contactBook = new ContactBook();

    private Contact contact = new Contact("tonny", "frisk", "1234560", "mail@mail.se");

    private String[] newData = {"0","Tonny","Frisk","123456","email@email.com"};

    // checks if firstName changes to the contactBook correctly
    @Test
    void doesContactFirstNameChangeCorrectly() {
        contactBook.getContactBook().add(contact);
        Edit.editContact(newData,contactBook);
        assertEquals("Tonny", contactBook.getContactBook().get(0).getFirstName(), "Test failed");
    }

    // checks if lastName changes to the contactBook correctly
    @Test
    void doesContactLastNameChangeCorrectly() {
        contactBook.getContactBook().add(contact);
        Edit.editContact(newData,contactBook);
        assertEquals("Frisk", contactBook.getContactBook().get(0).getLastName(), "Test failed");
    }

    // checks if phoneNumber changes to the contactBook correctly
    @Test
    void doesContactPhoneNumberChangeCorrectly() {
        contactBook.getContactBook().add(contact);
        Edit.editContact(newData,contactBook);
        assertEquals("123456", contactBook.getContactBook().get(0).getPhoneNumber(), "Test failed");
    }

    // checks if email changes to the contactBook correctly
    @Test
    void doesContactEmailChangeCorrectly() {
        contactBook.getContactBook().add(contact);
        Edit.editContact(newData,contactBook);
        assertEquals("email@email.com", contactBook.getContactBook().get(0).getEmail(), "Test failed");
    }
}