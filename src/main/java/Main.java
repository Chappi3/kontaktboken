import app.*;
import domain.ContactBook;
import file.FileOperations;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main class start application
 *
 * @author Maksym
 * @since 2018-12-01
 */

public class Main {
    public static void main(String[] args) throws IOException {
        ContactBook contactBook = new ContactBook();
        String contactBookName;
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        String choice = "";
        do{
            menu.mainMenu();
            choice = sc.nextLine();
            switch(choice){
                case "1":
                    System.out.println("\n --Create contact--");
                    Create.createContact(contactBook);
                    break;
                case "2":
                    System.out.println("\n --Edit contact--");
                    Edit.editContact(contactBook);
                    break;
                case "3":
                    System.out.println("\n --Delete contact--");
                    Delete.deleteContact(contactBook);
                    break;
                case "4":
                    System.out.println("\n --Find contact--");
                    String find = menu.searchMenu();
//                    Search.contains(find, contactBook);--
                    Search search = new Search();
                    search.searchName(find, contactBook);
                    search.searchLastName(find, contactBook);
                    search.searchNumber(find, contactBook);
                    search.searchEmail(find, contactBook);
//                    Lister.printContains(find, contactBook);
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
                    contactBookName = menu.saveMenu();
                    FileOperations.saveToJson(contactBookName, contactBook);
                    break;
                case "8":
                    System.out.println("\n --Load contact book--");
                    contactBookName = menu.loadMenu();
                    contactBook = FileOperations.loadFromJson(contactBookName);
                    break;
                default:
                    continue;
            }
        } while (!choice.equals("9"));
        System.out.println("exit...");
    }
}
