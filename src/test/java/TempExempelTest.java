import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TempExempelTest {

    @Test
    void tempMetod() {
        TempExempel tempExempel = new TempExempel();

        assertEquals("test",tempExempel.tempTest());
    }
}