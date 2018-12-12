import app.Create;
import app.Lister;
import app.Menu;
import domain.Contact;
import domain.ContactBook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactBook().add(new Contact("max","test","0386355241","max@mail.com"));
        contactBook.getContactBook().add(new Contact("bob","test","0943325529","bob@mail.com"));
        contactBook.getContactBook().add(new Contact("bil","test","0983435526","bil@mail.com"));
        contactBook.getContactBook().add(new Contact("tim","test","0726355264","tim@mail.com"));
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
                    menu.deleteMenu(contactBook);
                    break;
                case "4":
                    System.out.println("\n --Find contact--");
                    //find
                    break;
                case "5":
                    new Lister(contactBook).list();
                    break;
                default:
                    continue;
            }
        }while(!choice.equals("6"));
        System.out.println("exit...");
    }
}
