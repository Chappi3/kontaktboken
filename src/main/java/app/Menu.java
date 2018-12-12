package app;

import domain.Contact;
import domain.ContactBook;

import java.util.Scanner;

public class Menu {
    String firstName = "";
    String lastName = "";
    String phoneNumber = "";
    String email = "";
    Scanner sc = new Scanner(System.in);
    String input = "";
    int index;

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

    public String inputFirstName(){
        while(true){
            System.out.print("First name: ");
            input = sc.nextLine();
            if(Validator.checkName(input)){
                return input;
            }
        }
    }

    public String inputLastName(){
        while(true){
            System.out.print("Last name: ");
            input = sc.nextLine();
            if(Validator.checkName(input)){
                return input;
            }
        }
    }

    public String inputPhoneNumber(){
        while(true){
            System.out.print("Phone number: ");
            input = sc.nextLine();
            if(Validator.checkPhoneNumber(input)){
                return input;
            }
        }
    }

    public String inputEmail(){
        while(true){
            System.out.print("Email: ");
            input = sc.nextLine();
            if(Validator.checkEmail(input)){
                return input;
            }
        }
    }

    public String[] createMenu(){
        firstName = inputFirstName();
        lastName = inputLastName();
        phoneNumber = inputPhoneNumber();
        email = inputEmail();
        String[] data = new String[]{firstName, lastName, phoneNumber, email};
        return data;
    }


    public String[] editMenu(ContactBook contactBook){
        String[] data = new String[5];
        while(true) {
            System.out.print("Enter contact index: ");
            input = sc.nextLine();
            if (input.matches("[0-9]")) {
                index = Integer.parseInt(input) - 1;
                if(index < contactBook.getContactBook().size()) {
                    firstName = contactBook.getContactBook().get(index).getFirstName();
                    lastName = contactBook.getContactBook().get(index).getLastName();
                    phoneNumber = contactBook.getContactBook().get(index).getPhoneNumber();
                    email = contactBook.getContactBook().get(index).getEmail();
                    break;
                }
            }
        }
        do{
            System.out.println("1. Edit first name      ("+firstName+")");
            System.out.println("2. Edit last name       ("+lastName+")");
            System.out.println("3. Edit phone number    ("+phoneNumber+")");
            System.out.println("4. Edit email           ("+email+")");
            input = sc.nextLine();
        }while(!input.matches("[1-4]{1}"));
        switch (input){
            case "1":
                firstName = inputFirstName();
                break;
            case "2":
                lastName = inputLastName();
                break;
            case "3":
                phoneNumber = inputPhoneNumber();
                break;
            case "4":
                email = inputEmail();
                break;
            default: break;
        }
        data[0] = firstName;
        data[1] = lastName;
        data[2] = phoneNumber;
        data[3] = email;
        data[4] = String.valueOf((index));
        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);
        System.out.println(data[3]);
        System.out.println(data[4]);
        return data;
    }

    //ask user which contact to delete while not get valid input(integer and in the contact book)
    //return real index()
    public int deleteMenu(ContactBook contactBook){
        String[] data = new String[5];
        while(true) {
            System.out.print("Enter contact index: ");
            input = sc.nextLine();
            if (input.matches("[0-9]")) {
                index = Integer.parseInt(input) - 1;
                if(index < contactBook.getContactBook().size()) {
                    return index;
                }
            }
        }
    }
}
