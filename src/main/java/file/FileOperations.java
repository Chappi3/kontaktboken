package file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.ContactBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

    private static final ClassLoader CLASS_LOADER = FileOperations.class.getClassLoader();

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
     * @param fileName File Name
     * @return Loaded Contact book
     * @throws IOException If error
     */
    public static ContactBook loadFromJson(String fileName) throws IOException {

        InputStream resourceAsStream = CLASS_LOADER.getResourceAsStream(fileName);
        if (resourceAsStream == null)
            return new ContactBook();

        String jsonString = new BufferedReader(new InputStreamReader(resourceAsStream))
                .lines().collect(Collectors.joining());


        //File file = new File(fileName);
        //if (!file.exists())
        //     return new ContactBook();

        //String jsonString = Files.lines(file.toPath()).collect(Collectors.joining());
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


    /**
     * method collect all names of contact books (json only ) and return them without extensions
     *
     * @author Maksym
     * @since 2018-12-01
     */
    public List<String> getNamesOfContactBooks() {
        List<String> results = new ArrayList<String>();
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "samples";
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String filename = file.getName();
                if ((filename.substring(filename.length() - 5)).equals(".json")) {
                    results.add(file.getName().substring(0, filename.length() - 5));
                }
            }
        }
        return results;
    }
}
