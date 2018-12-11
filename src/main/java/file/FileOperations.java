package file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.ContactBook;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Collectors;

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

    /**
     * Load Contact book from json file
     *
     * @param fileName File name
     * @return Loaded Contact book
     * @throws IOException If error
     */
    public static ContactBook loadFromJson(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists())
            return null;

        String jsonString = Files.lines(file.toPath()).collect(Collectors.joining());
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, ContactBook.class);
    }

    /**
     * Save Contact book from json file
     *
     * @param fileName    File name
     * @param contactBook Contact book to save
     * @throws IOException If error
     */
    public static void saveToJson(String fileName, ContactBook contactBook) throws IOException {
        File file = new File(fileName);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(contactBook);
        try (FileOutputStream fos = new FileOutputStream(file); PrintWriter pw = new PrintWriter(fos)) {
            pw.print(jsonString);
        }
    }
}
