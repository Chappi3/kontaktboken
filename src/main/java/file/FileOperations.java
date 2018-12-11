package file;

import domain.ContactBook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileOperations {


    public static void saveToSerialized(String fileName, ContactBook contactBook) throws IOException {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(contactBook);
        }

    }
}
