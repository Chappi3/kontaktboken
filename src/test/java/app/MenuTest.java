package app;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class check if class Menu work correct
 *
 * @author Maksym
 * @since 2018-12-01
 */

class MenuTest {
    /**
     * Field
     *
     * @param menu, instance of class Menu
     */
    Menu menu = new Menu();

    /**
     * Compare print of mainMenu result with expected
     */
    @Test
    void checkIfMainMenuPrintMenu() throws Exception {
        String expectedOutput = "_______ MENU ________\n" +
                "1. Create contact    |\n" +
                "2. Edit contact      |\n" +
                "3. Delete contact    |\n" +
                "4. Search            |\n" +
                "5. Show all contacts |\n" +
                "6. New               |\n" +
                "7. Save              |\n" +
                "8. Load              |\n" +
                "9. Exit              |\n" +
                "_____________________|";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu.mainMenu();
        assertEquals(expectedOutput, outContent.toString().trim().replace("\r", ""));
    }

    /**
     * Try if method return names in expected readable format
     */
    @Test
    void checkNameFormatCorrector() {
        assertEquals("Maks", menu.nameFormatCorrector("mAKs"));
        assertEquals("Carl Johan Gustav", menu.nameFormatCorrector("caRL joHan gustav"));
    }

    /**
     * Try if method cast NullPointerException on input "0"
     */
    @Test
    void returnToMainMenu() {
        menu.input = "0";
        assertThrows(NullPointerException.class,
                () -> {
                    menu.returnToMainMenu();
                });
        Throwable exception = assertThrows(NullPointerException.class,
                () -> {
                    menu.returnToMainMenu();
                });
    }
}