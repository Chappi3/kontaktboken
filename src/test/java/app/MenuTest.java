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

//    @Test
//    void inputFirstName() {
//        String input = "0";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        menu.inputFirstName();
//        assertEquals("0", menu.inputFirstName());
////        Scanner sc = new Scanner("0");
////        assertThrows(NullPointerException.class,
////                ()->{
////                    menu.inputFirstName();
////                });
////        Throwable exception = assertThrows(NullPointerException.class,
////                ()->{menu.inputFirstName();} );
//    }

    @Test
    void inputLastName() {
    }

    @Test
    void inputPhoneNumber() {
    }

    @Test
    void inputEmail() {
    }

    @Test
    void createMenu() {
    }

    @Test
    void editMenu() {
    }

    @Test
    void deleteMenu() {
    }

    @Test
    void searchMenu() {
    }

    @Test
    void saveMenu() {
    }

    @Test
    void loadMenu() {
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