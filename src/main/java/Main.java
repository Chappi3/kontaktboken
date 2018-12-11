import app.Menu;
import domain.Contact;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        String choice = "";

        do{
            menu.mainMenu();
            choice = sc.nextLine();
            switch(choice){
                case "1":
                    System.out.println("\n --Create contact--");
                    menu.createMenu();
                    //create
                    break;
                case "2":
                    System.out.println("\n --Edit contact--");
                    menu.editMenu();
                    //edit
                    break;
                case "3":
                    System.out.println("\n --Delete contact--");
                    menu.deleteMenu();
                    //delete
                    break;
                case "4":
                    System.out.println("\n --Find contact--");
                    //find
                    break;
                case "5":
                    System.out.println("\n --Contacts--");
                    //show all contacts
                    break;
                default:
                    continue;
            }
        }while(!choice.equals("6"));
        System.out.println("exit...");
    }
}
