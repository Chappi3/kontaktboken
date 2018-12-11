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


}