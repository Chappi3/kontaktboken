package file;

import domain.Contact;
import domain.ContactBook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class FileOperationsTest {

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


        if (file.exists()) {
            try {
                Files.delete(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}