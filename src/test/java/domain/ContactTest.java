package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class check if class Contact work correct
 *
 * @author Maksym
 * @since 2018-12-01
 */

class ContactTest {
    /**
     * Field
     */
    Contact contact = new Contact("Maks", "G", "56576687", "maks@mail.com");

    /**
     *Check if equals() work correct
     */
    @Test
    void equals() {
        assertTrue(contact.equals(contact));
        assertFalse(contact.equals(null));
        String notThisClass = new String("22");
        assertFalse(contact.equals(notThisClass));
        Contact contact2 = (Contact) contact;
        assertEquals(contact.getEmail(), contact2.getEmail());
    }

    /**
     * Check if hashCode return right value
     */
    @Test
    void TestHashCode() {
        int a = java.util.Objects.hash(contact.getEmail());
        int b = contact.hashCode();
        assertEquals(a, b);
    }

    /**
     * Testing toString() for Contact
     */
    @Test
    void TestToString() {
        String s = "Name: " + contact.getFirstName() + ' ' + contact.getLastName() + '\n' +
                "Phone: " + contact.getPhoneNumber() + '\n' +
                "Email: " + contact.getEmail();
        assertEquals(contact.toString(), s);
    }

    /**
     *Check inserting and getting value from first name
     */
    @Test
    void firstNameSetterAndGetter() {
        contact.setFirstName("newMaks");
        assertEquals(contact.getFirstName(), "newMaks");
    }

    /**
     *Check inserting and getting value from last name
     */
    @Test
    void lastNameSetterAndGetter() {
        contact.setLastName("newG");
        assertEquals(contact.getLastName(), "newG");
    }

    /**
     *Check if get value from phone number
     */
    @Test
    void getPhoneNumber() {
        assertEquals(contact.getPhoneNumber(), "56576687");
    }

    /**
     *Check if insert value for last name
     */
    @Test
    void setPhoneNumber() {
        contact.setPhoneNumber("078888");
        assertEquals("078888", contact.getPhoneNumber());
    }

    /**
     *Check if get value from email
     */
    @Test
    void getEmail() {
        assertEquals(contact.getEmail(), "maks@mail.com");
    }

    /**
     *Check if set value to email
     */
    @Test
    void setEmail() {
        contact.setEmail("newmaks@mail.com");
        assertEquals("newmaks@mail.com", contact.getEmail());
    }
}