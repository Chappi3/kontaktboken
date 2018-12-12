package util;

import domain.Contact;
import domain.ContactBook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Using names and emails found on randomlists.com
 */
public class FakeContacts {

    public static ContactBook createBook(int size) {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactBook().addAll(createContacts(size));
        return contactBook;
    }

    public static List<Contact> createContacts(int size) {


        return contacts(size, null, null, null);
    }

    private static List<Contact> contacts(int size, List<String> firstNames, List<String> lastNames, List<String> emails) {
        return null;
    }

    private static List<String> lines(String fileName) {
        File file = new File(fileName);
        if (!file.exists())
            return new ArrayList<>();

        try {
            return Files.lines(file.toPath()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
