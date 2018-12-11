package app;

import java.util.Scanner;

public class Menu {
    String firstName, lastName, email, phoneNumber;
    Scanner sc = new Scanner(System.in);
    String input = "";

    public void mainMenu(){
        System.out.println("\n_______ MENU ________");
        System.out.println("1. Create contact    |");
        System.out.println("2. Edit contact      |");
        System.out.println("3. Delete contact    |");
        System.out.println("4. Find contact      |");
        System.out.println("5. Show all contacts |");
        System.out.println("6. Exit              |");
        System.out.println("_____________________|");
    }

    public String[] createMenu(){
        while(true){
            System.out.print("Name: ");
            input = sc.nextLine();
            if(Validator.checkName(input)){
                firstName = input; break;
            }
        }
        while(true){
            System.out.print("Last name: ");
            input = sc.nextLine();
            if(Validator.checkName(input)){
                lastName = input; break;
            }
        }
        while(true){
            System.out.print("Phone number: ");
            input = sc.nextLine();
            if(Validator.checkPhoneNumber(input)){
                phoneNumber = input; break;
            }
        }
        while(true){
            System.out.print("Email: ");
            input = sc.nextLine();
            if(Validator.checkEmail(input)){
                email = input; break;
            }
        }
        String[] data = new String[]{firstName, lastName, phoneNumber, email};
        return data;
    }

    public String editMenu(){
        return null;
    }

    public String deleteMenu(){
        return null;
    }

}
