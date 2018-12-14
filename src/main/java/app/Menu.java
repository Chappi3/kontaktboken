package app;

import domain.ContactBook;
import file.FileOperations;

import java.util.List;
import java.util.Scanner;

/**
 * Class consisting all menus for command line input
 *
 * @author Maksym
 * @since 2018-12-01
 */

public class Menu {
    //fields
    String firstName = "";
    String lastName = "";
    String phoneNumber = "";
    String email = "";
    Scanner sc = new Scanner(System.in);
    String input = "";
    int index;

    //print main menu
    public void mainMenu(){
        System.out.println("\n_______ MENU ________");
        System.out.println("1. Create contact    |");
        System.out.println("2. Edit contact      |");
        System.out.println("3. Delete contact    |");
        System.out.println("4. Search            |");
        System.out.println("5. Show all contacts |");
        System.out.println("6. New               |");
        System.out.println("7. Save              |");
        System.out.println("8. Load              |");
        System.out.println("9. Exit              |");
        System.out.println("_____________________|");
    }

    //name format corrector, ex. in:"daVid dRESden" out:"David Dresden"
    public String nameFormatCorrector(String input) {
        String[] splitedInput = input.trim().split("\\s+");
        String result = splitedInput[0].substring(0, 1).toUpperCase() + splitedInput[0].substring(1).toLowerCase();
        for (int i = 1; i < splitedInput.length; i++) {
            result += " " + splitedInput[i].substring(0, 1).toUpperCase() + splitedInput[i].substring(1).toLowerCase();
        }
        return result;
    }

    //asking for first name while it's not valid, return checked
    public String inputFirstName(){
        while(true){
            System.out.print("First name: ");
            input = sc.nextLine();
            if (Validator.checkName(input)) {
                return nameFormatCorrector(input);
            }
        }
    }

    //asking for last name while it's not valid, return checked
    public String inputLastName(){
        while(true){
            System.out.print("Last name: ");
            input = sc.nextLine();
            if(Validator.checkName(input)){
                return nameFormatCorrector(input);
            }
        }
    }

    //asking for phone number while it's not valid, return checked
    public String inputPhoneNumber(){
        while(true){
            System.out.print("Phone number: ");
            input = sc.nextLine();
            if(Validator.checkPhoneNumber(input)){
                return input;
            }
        }
    }

    //asking for email while it's not valid, return checked
    public String inputEmail(){
        while(true){
            System.out.print("Email: ");
            input = sc.nextLine();
            if(Validator.checkEmail(input)){
                return input;
            }
        }
    }

    //menu for contact creator, asking for contact fields while it's not valid, return checked
    //return (first name, second name, phone number, email) som String[]
    public String[] createMenu(){
        firstName = inputFirstName();
        lastName = inputLastName();
        phoneNumber = inputPhoneNumber();
        email = inputEmail();
        String[] data = new String[]{firstName, lastName, phoneNumber, email};
        return data;
    }

    //menu for contact editor, asking for contact index while it's not valid, return checked new fields and index
    //return (index, first name, second name, phone number, email) som String[]
    public String[] editMenu(ContactBook contactBook){
        String[] data = new String[5];
        System.out.println();
        while(true) {
            System.out.print("Enter contact index(press '0' for exit): ");
            input = sc.nextLine();
            if (input.equals("0")) {
                return null;
            } else if (input.matches("[0-9]+")) {
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
        data[0] = String.valueOf((index));
        data[1] = firstName;
        data[2] = lastName;
        data[3] = phoneNumber;
        data[4] = email;
        return data;
    }

    //menu for contact deleting, asking for contact index while it's not valid, return index
    //return int index
    public int deleteMenu(ContactBook contactBook){
        String[] data = new String[5];
        while(true) {
            System.out.print("Enter contact index: ");
            input = sc.nextLine();
            if (input.matches("[0-9]+")) {
                index = Integer.parseInt(input) - 1;
                if(index < contactBook.getContactBook().size()) {
                    return index;
                }
            }
        }
    }

    //menu for contact searching, asking for search text, return not checked
    //return text
    public String searchMenu() {
        System.out.print("Search: ");
        input = sc.nextLine();
        return input;
    }

    //meu for saving contact book to json file
    public String saveMenu() {
        System.out.print("Save contact book as: ");
        input = sc.nextLine();
        return input.toLowerCase() + ".json";
    }

    //menu for loading contact book from json file
    public String loadMenu() {
        FileOperations fileOperations = new FileOperations();
        List<String> contactBooks = fileOperations.getNamesOfContactBooks();
        int i = 0;
        for (String book : contactBooks) {
            System.out.println(++i + ". " + book);
        }
        do {
            System.out.print("\nChoose contact book: ");
            input = sc.nextLine();
            if ((input.matches("[0-9]+")) && (Integer.parseInt(input) <= contactBooks.size())) {
                break;
            }
            System.out.println("invalid input, choose between " + 1 + " and " + contactBooks.size());
        } while (true);
        String contactBookName = contactBooks.get(Integer.parseInt(input) - 1);
        return contactBookName + ".json";
    }
}
