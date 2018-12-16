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
     * field
     */
    Contact contact = new Contact("Maks", "G", "56576687", "maks@mail.com");

    /**
     *test if equals() work correct
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

//    @Test
//    void hashCode() {
//        int a = java.util.Objects.hash(contact.getEmail());
//        int b = contact.hashCode();
//        assertEquals(a, b);
//    }

//    @Test
//    void toString() {
//        String s = "Name: " + contact.getFirstName() + ' ' + contact.getLastName() + '\n' +
//                   "Phone: " + contact.getPhoneNumber() + '\n' +
//                   "Email: " + contact.getEmail();
//        assertEquals(contact.toString(), s);
//    }

    /**
     *Check inserting/getting value from firstName
     */
    @Test
    void firstNameSetterAndGetter() {
        contact.setFirstName("newMaks");
        assertEquals(contact.getFirstName(), "newMaks");
    }

    //Check inserting/getting value from lastName
    @Test
    void lastNameSetterAndGetter() {
        contact.setLastName("newG");
        assertEquals(contact.getLastName(), "newG");
    }


    @Test
    void getPhoneNumber() {
        assertEquals(contact.getPhoneNumber(), "56576687");
    }

    @Test
    void setPhoneNumber() {
        contact.setPhoneNumber("078888");
        assertEquals("078888", contact.getPhoneNumber());
    }

    @Test
    void getEmail() {
        assertEquals(contact.getEmail(), "maks@mail.com");
    }

    @Test
    void setEmail() {
        contact.setEmail("newmaks@mail.com");
        assertEquals("newmaks@mail.com", contact.getEmail());
    }
}