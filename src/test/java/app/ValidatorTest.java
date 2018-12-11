package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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


}