package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Maksym Gorbunov
 * @since 2018-12-12
*/

class ValidatorTest {
    @Test
    void checkValidName() {
        Validator validator = new Validator();
        String name = "Maks";
        boolean result = validator.checkName(name);
        assertEquals(result, true);
    }
    @Test
    void checkNotValidName() {
        Validator validator = new Validator();
        String name = "maks76";
        boolean result = validator.checkName(name);
        assertEquals(result, false);
    }
    @Test
    void checkValidPhoneNumber() {
        Validator validator = new Validator();
        String phoneNumber = "0763187075";
        boolean result = validator.checkPhoneNumber(phoneNumber);
        assertEquals(result, true);
    }
    @Test
    void checkNotValidPhoneNumber() {
        Validator validator = new Validator();
        String phoneNumber = "7075aa";
        boolean result = validator.checkPhoneNumber(phoneNumber);
        assertEquals(result, false);
    }
    @Test
    void checkValidEmail() {
        Validator validator = new Validator();
        String email = "maks.iths@gmail.com";
        boolean result = validator.checkEmail(email);
        assertEquals(result, true);
    }
    @Test
    void checkNotValidEmail() {
        Validator validator = new Validator();
        String email = "maks-iths.mail.com";
        boolean result = validator.checkEmail(email);
        assertEquals(result, false);
    }
}