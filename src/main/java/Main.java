import app.Create;
import app.Menu;
import domain.Contact;
import domain.ContactBook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
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
//                    Edit.editContacts(contactBook);
                    String[] data = new String[5];
                    data = menu.editMenu(contactBook);
                    break;
                case "3":
                    System.out.println("\n --Delete contact--");
//                    Delete.deleteContact(contactBook);
                    break;
                case "4":
                    System.out.println("\n --Find contact--");
                    //find
                    break;
                case "5":
                    System.out.println("\n --Contacts--");
//                    new Lister(contacts).list();
                    break;
                default:
                    continue;
            }
        }while(!choice.equals("6"));
        System.out.println("exit...");
    }
}
