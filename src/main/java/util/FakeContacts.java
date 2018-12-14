package util;

import domain.Contact;
import domain.ContactBook;
import file.FileOperations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Class for creating random contacts
 * samples/firstnames.txt, samples/lastnames.txt and samples/emails.txt are gathered
 * from randomlists.com
 *
 * @author hjalmar
 * @since 2018-12-12
 */
public class FakeContacts {

    private static final ClassLoader CLASS_LOADER = FakeContacts.class.getClassLoader();

    /**
     * @param size Amount of contacts to generate
     * @return Contact book
     */
    public static ContactBook createBook(int size) {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactBook().addAll(createContacts(size));
        return contactBook;
    }

    /**
     * @param size Amount of contacts to generate
     * @return List with contacts
     */
    public static List<Contact> createContacts(int size) {
        return contacts(size, lines("firstnames.txt"), lines("lastnames.txt"), lines("emails.txt"));
    }

    /**
     * Randomly picks from each list to generate combinations
     *
     * @param size       Amount of contacts to generate
     * @param firstNames List of first names
     * @param lastNames  List of last names
     * @param emails     List of emails
     * @return List of contacts
     */
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

    /**
     * Create List of lines from file
     *
     * @param fileName file to pick from
     * @return List of lines from file
     */
    public static List<String> lines(String fileName) {
        try {


            InputStream resourceAsStream = new FileInputStream(FileOperations.path + fileName);
            if (resourceAsStream == null)
                return new ArrayList<>();

            return new BufferedReader(new InputStreamReader(resourceAsStream))
                    .lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }

}
