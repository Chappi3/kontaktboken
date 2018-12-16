package app;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This test runs at a 100% Class, 80% Method, 86% Line coverage. The one method that is skipped is
 * only calling the methods in the Search class that are already tested with 100% coverage.
 *
 * @author Ilari Silander
 * @version 1.0
 * @since 2018-12-16
 */

class SearchTest {

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    PrintStream old = System.out;


    ContactBook contactBook = new ContactBook();
    Search search = new Search();
    Contact contact = new Contact("ilari", "silander","123456", "email@email.se");

    @BeforeEach
    public void InitializeOutputCapture() {
        System.setOut(ps);
    }

    @AfterEach
    public void ResetSystemOut() {
        System.setOut(old);
    }

    @Test
    void DoesContactBookIndexZeroGetFirstNameContainCorrectName() {
        String testInput = "ilari";
        contactBook.getContactBook().add(contact);
        search.searchName(testInput,contactBook);

        assertTrue(baos.toString().contains("ilari"),"Should contain: 'ilari'");

    }

    @Test
    void DoesContactBookIndexZeroGetLastNameContainCorrectLastName() {
        String testInput = "silander";
        contactBook.getContactBook().add(contact);
        search.searchLastName(testInput,contactBook);

        assertTrue(baos.toString().contains("silander"),"Should contain: 'silander'");
    }

    @Test
    void DoesContactBookIndexZeroGetEmailNameContainTheCorrectEmail() {
        String testInput = "email@email.se";
        contactBook.getContactBook().add(contact);
        search.searchEmail(testInput,contactBook);

        assertTrue(baos.toString().contains("email@email.se"),"Should contain: 'email@email.se'");
    }

    @Test
    void DoesContactBookIndexZeroGetNumberContainTheCorrectNumber() {
        String testInput = "123456";
        contactBook.getContactBook().add(contact);
        search.searchNumber(testInput,contactBook);

        assertTrue(baos.toString().contains("123456"),"Should contain: '123456'");
    }

    @Test
    void CheckIfContactBookIsEmptyOrNot() {
        String testInput = "testing";
        search.searchName(testInput, contactBook);
        search.searchLastName(testInput,contactBook);
        search.searchNumber(testInput,contactBook);
        search.searchEmail(testInput,contactBook);

        assertTrue(baos.toString().contains("There are no contacts in the contact book"));
    }
}