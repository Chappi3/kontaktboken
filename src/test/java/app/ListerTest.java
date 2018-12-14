package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Hjalmar
 * @since 2018-12-06
 */
class ListerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));


    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);

    }

    @Test
    void list() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactBook().add(new Contact("Hjalmar", "Ar", "0709", "email@email.com"));
        contactBook.getContactBook().add(new Contact("Hjalmar", "Arasdffsafdssdfsdfsdf", "0709", "email@email.com"));

        Lister.list(contactBook);
        assertEquals(System.getProperty("line.separator") +
                "Nr     First Name                Last Name                 Phone                     Email                    " + System.getProperty("line.separator") +
                "1      Hjalmar                   Ar                        0709                      email@email.com          " + System.getProperty("line.separator") +
                "2      Hjalmar                   Arasdffsafdssdfsdfsdf     0709                      email@email.com          " + System.getProperty("line.separator"), outContent.toString());
    }

    @Test
    void containsTest() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactBook().add(new Contact("Hjalmar", "Ar", "0709", "email@email.com"));
        contactBook.getContactBook().add(new Contact("Hjalmar", "Arasdffsafdssdfsdfsdf", "0709", "email@email.com"));
        contactBook.getContactBook().add(new Contact("max", "test", "0386355241", "max@mail.com"));
        contactBook.getContactBook().add(new Contact("bob", "test", "0943325529", "bob@mail.com"));
        contactBook.getContactBook().add(new Contact("bil", "test", "0983435526", "bil@mail.com"));
        contactBook.getContactBook().add(new Contact("tim", "test", "0720709264", "tim@mail.com"));
        String find = "bob";
        List<Contact> contains = Lister.contains(find, contactBook);
        assertTrue(1 == contains.size());
        assertEquals(find, contains.get(0).getFirstName());
    }

    @Test
    void contains2Test() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactBook().add(new Contact("Hjalmar", "Ar", "0709", "email@email.com"));
        contactBook.getContactBook().add(new Contact("Hjalmar", "Arasdffsafdssdfsdfsdf", "0709", "email@email.com"));
        contactBook.getContactBook().add(new Contact("max", "test", "0386355241", "max@mail.com"));
        contactBook.getContactBook().add(new Contact("bob", "test", "0943325529", "bob@mail.com"));
        contactBook.getContactBook().add(new Contact("bil", "test", "0983435526", "bil@mail.com"));
        contactBook.getContactBook().add(new Contact("tim", "test", "0720709264", "tim@mail.com"));
        String find = "0709";
        Lister.printContains(find, contactBook);
        assertEquals(System.getProperty("line.separator") +
                        "Nr     First Name                Last Name                 Phone                     Email                    " + System.getProperty("line.separator") +
                        "1      Hjalmar                   Ar                        0709                      email@email.com          " + System.getProperty("line.separator") +
                        "2      Hjalmar                   Arasdffsafdssdfsdfsdf     0709                      email@email.com          " + System.getProperty("line.separator") +
                        "3      tim                       test                      0720709264                tim@mail.com             " + System.getProperty("line.separator")
                , outContent.toString());

    }

    @Test
    void longnameTest() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactBook().add(new Contact("Hjalmar", "Långtefternamn asassasasasasasasasasasas", "0709", "email@email.com"));
        Lister.list(contactBook);
        assertEquals(System.getProperty("line.separator") +
                        "Nr     First Name                Last Name                 Phone                     Email                    " + System.getProperty("line.separator") +
                        "1      Hjalmar                   Långtefternamn asassas... 0709                      email@email.com          "
                        + System.getProperty("line.separator")
                , outContent.toString());


    }

    @Test
    void longNameTest2() {
        ContactBook contactBook2 = new ContactBook();
        contactBook2.getContactBook().add(new Contact("Hjalmar HjalmarHjalmar  Hjalmar Hjalmar Hjalmar", "Långtefternamn Asassasasasasasasasasasas", "0709", "email@email.com"));
        Lister.list(contactBook2);
        assertEquals(System.getProperty("line.separator") +
                        "Nr     First Name                Last Name                 Phone                     Email                    " + System.getProperty("line.separator") +
                        "1      Hjalmar HjalmarHjalmar... Långtefternamn Asassas... 0709                      email@email.com          "
                        + System.getProperty("line.separator")
                , outContent.toString());
    }
}