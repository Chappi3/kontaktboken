package file;

import domain.ContactBook;

import java.io.*;

/**
 * Class for loading and saving
 *
 * @author hjalmar
 * @see domain.Contact
 * @see ContactBook
 * @since 2018-12-11
 */
public class FileOperations {

    /**
     * Load Contact book from serialized file
     *
     * @param fileName File name
     * @return Loaded Contact book
     * @throws IOException            If IOException
     * @throws ClassNotFoundException Serializable error
     */
    public static ContactBook loadFromSerialized(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists())
            return null;

        try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
            return ((ContactBook) ois.readObject());
        }
    }

    /**
     * Save Contact book to serialized file
     *
     * @param fileName    File name
     * @param contactBook Contact book to save
     * @throws IOException If error
     */
    public static void saveToSerialized(String fileName, ContactBook contactBook) throws IOException {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(contactBook);
        }

    }
}
