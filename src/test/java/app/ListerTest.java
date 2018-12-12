package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Lister lister = new Lister(contactBook);
        lister.list();
        assertEquals("      First Name          Last Name                 Phone                     Email                    " + System.getProperty("line.separator") +
                "1     Hjalmar             Ar                        0709                      email@email.com          " + System.getProperty("line.separator") +
                "2     Hjalmar             Arasdffsafdssdfsdfsdf     0709                      email@email.com          " + System.getProperty("line.separator"), outContent.toString());
    }
}