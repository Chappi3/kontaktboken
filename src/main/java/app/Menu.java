package app;

import java.util.Scanner;

public class Menu {
    String firstName, lastName, email, phoneNumber;
    Scanner sc = new Scanner(System.in);
    String input = "";

    public void mainMenu(){
//        int choise =
                System.out.println("_______ MENU ________");
        System.out.println("1. Create contact    |");
        System.out.println("2. Edit contact      |");
        System.out.println("3. Delete contact    |");
        System.out.println("4. Find contact      |");
        System.out.println("5. Show all contacts |");
        System.out.println("6. Exit              |");
        System.out.println("_____________________|");
    }

}
