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
            System.out.print("First name: ");
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

    public String[] editMenu(ContactBook contactBook){
        int index;
        String[] data = new String[5];
        while(true) {
            System.out.print("Enter contact index: ");
            input = sc.nextLine();
            if (input.matches("[0-9]")) {
                index = Integer.parseInt(input);
                if (index < contactBook.getContactBook().size()) {
                    do{
                        System.out.println("1. Edit first name");
                        System.out.println("2. Edit last name");
                        System.out.println("3. Edit phone number");
                        System.out.println("4. Edit email");
                        input = sc.nextLine();
                    }while(input.matches("[1-4]{1}"));
                    while(true){
                        switch (input){
                            case "1":
                                while(true){
                                    System.out.print("First name ("+contactBook.getContactBook().get(index-1)+"): ");
                                    input = sc.nextLine();
                                    if(Validator.checkName(input)){
                                        firstName = input; break;
                                    }
                                }
                            case "2":
                                while(true){
                                    System.out.print("Last name ("+contactBook.getContactBook().get(index-1)+"): ");
                                    input = sc.nextLine();
                                    if(Validator.checkName(input)){
                                        lastName = input; break;
                                    }
                                }
                            case "3":
                                while(true){
                                    System.out.print("Phone number ("+contactBook.getContactBook().get(index-1)+"): ");
                                    input = sc.nextLine();
                                    if(Validator.checkPhoneNumber(input)){
                                        phoneNumber = input; break;
                                    }
                                }
                            case "4":
                                while(true){
                                    System.out.print("Email ("+contactBook.getContactBook().get(index-1)+"): ");
                                    input = sc.nextLine();
                                    if(Validator.checkEmail(input)){
                                        email = input; break;
                                    }
                                }
                            default: continue;
                        }
                    }
                    data[0] = firstName;
                    data[1] = lastName;
                    data[2] = phoneNumber;
                    data[3] = email;
                    data[4] = String.valueOf((index-1));
                }
            }
        }
        return data;
    }

    public String deleteMenu(){
        return null;
    }

}
