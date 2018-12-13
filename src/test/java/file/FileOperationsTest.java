package file;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test file for File save and load
 */
class FileOperationsTest {

    /**
     * Test serialized for save and load
     * removes test file before and after
     */
    @Test
    void saveToSerialized() {
        String fileName = "Serializedtestfile";
        File file = new File(fileName);
        if (file.exists()) {
            try {
                Files.delete(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String firstName = "first";
        String lastName = "last";
        String phone = "22222";
        String email = "aaaa@aaa.com";

        ContactBook contactBook = new ContactBook();
        Contact contact = new Contact(firstName, lastName, phone, email);
        contactBook.getContactBook().add(contact);
        try {
            FileOperations.saveToSerialized(fileName, contactBook);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ContactBook loadedBook = null;
        try {
            loadedBook = FileOperations.loadFromSerialized(fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assertNotNull(loadedBook);

        assertEquals(contactBook.getContactBook().get(0), loadedBook.getContactBook().get(0));

        try {
            assertNull(FileOperations.loadFromSerialized("NonExistingFile"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (file.exists()) {
            try {
                Files.delete(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Test json for save and load
     * removes test file before and after
     */
    @Test
    void saveToJson() {

        String fileName = "Jsonfile.json";
        File file = new File(fileName);
        if (file.exists()) {
            try {
                Files.delete(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String firstName = "first";
        String lastName = "last";
        String phone = "22222";
        String email = "aaaa@aaa.com";

        ContactBook contactBook = new ContactBook();
        Contact contact = new Contact(firstName, lastName, phone, email);
        contactBook.getContactBook().add(contact);
        try {
            FileOperations.saveToJson(fileName, contactBook);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ContactBook loadedBook = null;
        try {
            loadedBook = FileOperations.loadFromJson(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(loadedBook);
//        System.out.println(loadedBook.getContactBook().size());
//        assertEquals(contactBook.getContactBook().get(0), loadedBook.getContactBook().get(0));

//        try {
//            assertNull(FileOperations.loadFromJson("NonExistingFile"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        if (file.exists()) {
            try {
                Files.delete(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void testSampleFile1000() {
        try {
            System.out.println(new File(this.getClass().getClassLoader().getResource("samples" + File.separator + "contacts1000.json").getFile()));
            File file = new File(this.getClass().getClassLoader().getResource("samples" + File.separator + "contacts1000.json").getFile());
            ContactBook fromJson = FileOperations.loadFromJson("samples" + File.separator + "contacts1000.json");
            assertEquals(1000, fromJson.getContactBook().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}