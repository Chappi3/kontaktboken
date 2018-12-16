package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class check if class Validator work correct
 *
 * @author Maksym
 * @since 2018-12-01
 */

class ValidatorTest {
    /**
     * Check if name validator work correct on right input
     */
    @Test
    void checkValidName() {
        Validator validator = new Validator();
        String name = "Maks";
        boolean result = validator.checkName(name);
        assertEquals(result, true);
    }

    /**
     *Check if name validator work correct on wrong input
     */
    @Test
    void checkNotValidName() {
        Validator validator = new Validator();
        String name = "maks76";
        boolean result = validator.checkName(name);
        assertEquals(result, false);
    }

    /**
     *Check if phone number validator work correct on right input
     */
    @Test
    void checkValidPhoneNumber() {
        Validator validator = new Validator();
        String phoneNumber = "0763187075";
        boolean result = validator.checkPhoneNumber(phoneNumber);
        assertEquals(result, true);
    }

    /**
     *Check if phone number validator work correct on wrong input
     */
    @Test
    void checkNotValidPhoneNumber() {
        Validator validator = new Validator();
        String phoneNumber = "7075aa";
        boolean result = validator.checkPhoneNumber(phoneNumber);
        assertEquals(result, false);
    }

    /**
     *Check if email validator work correct on right input
     */
    @Test
    void checkValidEmail() {
        Validator validator = new Validator();
        String email = "maks.iths@gmail.com";
        boolean result = validator.checkEmail(email);
        assertEquals(result, true);
    }

    /**
     *Check if email validator work correct on wrong input
     */
    @Test
    void checkNotValidEmail() {
        Validator validator = new Validator();
        String email = "maks-iths.mail.com";
        boolean result = validator.checkEmail(email);
        assertEquals(result, false);
    }
}