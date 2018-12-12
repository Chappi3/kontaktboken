package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class check if class Contact work correct
 *
 * @author Maksym
 * @since 2018-12-01
 */

class ContactTest {

//    @Test
//    void equals() {
//    }
//
//    @Test
//    void hashCode() {
//    }
//
//    @Test
//    void toString() {
//    }

    //Check inserting/getting value from firstName
    @Test
    void firstNameSetterAndGetter() {
        Contact c = new Contact("Maks", "G", "56576687", "mkas@mail.com");
        c.setFirstName("newMaks");
        assertEquals(c.getFirstName(), "newMaks");
    }

    //Check inserting/getting value from lastName
    @Test
    void lastNameSetterAndGetter() {
        Contact c = new Contact("Maks", "G", "56576687", "mkas@mail.com");
        c.setLastName("newG");
        assertEquals(c.getLastName(), "newG");
    }


//    @Test
//    void getPhoneNumber() {
//    }
//
//    @Test
//    void setPhoneNumber() {
//    }
//
//    @Test
//    void getEmail() {
//    }
//
//    @Test
//    void setEmail() {
//    }
}