import app.*;
import domain.ContactBook;
import file.FileOperations;

import java.io.File;
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
//        FakeContacts.createContacts(10);
        ContactBook contactBook = FileOperations.loadFromJson("samples" + File.separator + "contacts1000.json");
//        ContactBook contactBook = new ContactBook(FakeContacts.contacts(8));


        //read file - > create createContactBook else create new book
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
                default:
                    continue;
            }
        }while(!choice.equals("6"));
        System.out.println("exit...");
    }
}
