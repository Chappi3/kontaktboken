import app.*;
import domain.ContactBook;
import file.FileOperations;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Main class start application
 * @author Maksym, Hjalmar
 * @since 2018-12-01
 */

public class Main {

    /**
     * Start current application
     */
    public static void main() {
        try {
            start();
            System.out.println("Exit...");
        } catch (NoSuchElementException e) {
            System.out.println(System.getProperty("line.separator") + "Abrupt exit...");
        }
    }

    /**
     * Main menu with all possible contact operations
     */
    public static void start() {
        ContactBook contactBook = new ContactBook();
        String contactBookName;
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        String choice = "";
        do {
            menu.mainMenu();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("\n --Create contact--");
                    try {
                        Create.createContact(new Menu().createMenu(), contactBook);
                    } catch (NullPointerException e) {
                    }
                    break;
                case "2":
                    System.out.println("\n --Edit contact--");
                    try {
                        Lister.list(contactBook);
                        Edit.editContact(new Menu().editMenu(contactBook), contactBook);
                    } catch (NullPointerException e) {
                    }
                    break;
                case "3":
                    System.out.println("\n --Delete contact--");
                    try {
                        Lister.list(contactBook);
                        Delete.deleteContact(new Menu().deleteMenu(contactBook), contactBook);
                    } catch (NullPointerException e) {
                    }
                    break;
                case "4":
                    System.out.println("\n --Find contact--");
                    try {
                        String find = menu.searchMenu();
                        Search.search(find, contactBook);
                    } catch (NullPointerException e) {
                    }
                    break;
                case "5":
                    Lister.list(contactBook);
                    break;
                case "6":
                    System.out.println("\n --New contact book--");
                    contactBook = new ContactBook();
                    break;
                case "7":
                    System.out.println("\n --Save contact book--");
                    try {
                        contactBookName = menu.saveMenu();
                        FileOperations.saveToJson(contactBookName, contactBook);
                    } catch (IOException e) {
                        System.out.println("Saving failed, try again");
                    } catch (NullPointerException e) {
                    }
                    break;
                case "8":
                    System.out.println("\n --Load contact book--");
                    try {
                        contactBookName = menu.loadMenu();
                        contactBook = FileOperations.loadFromJson(contactBookName);
                    } catch (IOException e) {
                        System.out.println("Loading failed, try again");
                    } catch (NullPointerException e) {
                    }
                    break;
                default:
                    continue;
            }
        } while (!choice.equals("9"));
    }
}
