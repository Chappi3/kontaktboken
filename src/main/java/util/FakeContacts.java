package util;

import domain.Contact;
import domain.ContactBook;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Using names and emails found on randomlists.com
 */
public class FakeContacts {

    private static final ClassLoader classLoader = FakeContacts.class.getClassLoader();

    public static ContactBook createBook(int size) {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactBook().addAll(createContacts(size));
        return contactBook;
    }

    public static List<Contact> createContacts(int size) {
        return contacts(size, lines("samples/firstnames.txt"), lines("samples/lastnames.txt"), lines("samples/emails.txt"));
    }

    private static List<Contact> contacts(int size, List<String> firstNames, List<String> lastNames, List<String> emails) {
        int f = firstNames.size();
        int l = lastNames.size();
        int e = emails.size();
        ThreadLocalRandom random = ThreadLocalRandom.current();

        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            contacts.add(new Contact(firstNames.get(random.nextInt(0, f)), lastNames.get(random.nextInt(0, l)), String.valueOf(random.nextInt(1000000, 1000000000)), emails.get(random.nextInt(0, e))));
        }
        return contacts;
    }

    public static List<String> lines(String fileName) {

        URL resource = classLoader.getResource(fileName);
        if (resource == null)
            return new ArrayList<>();

        File file = new File(resource.getFile());
        if (!file.exists())
            return new ArrayList<>();

        try {
            return Files.lines(file.toPath()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
