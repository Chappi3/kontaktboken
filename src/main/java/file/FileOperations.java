package file;

import domain.ContactBook;

import java.io.*;


public class FileOperations {


    public static ContactBook loadFromSerialized(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists())
            return null;

        try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
            return ((ContactBook) ois.readObject());
        }
    }

    public static void saveToSerialized(String fileName, ContactBook contactBook) throws IOException {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(contactBook);
        }

    }
}
