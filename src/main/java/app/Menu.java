package app;

import domain.ContactBook;
import file.FileOperations;

import java.util.List;
import java.util.Scanner;

/**
 * Class consisting all menus for command line input
 * @author Maksym
 * @since 2018-12-01
 */

public class Menu {
    /**
     * Fields
     */
    String firstName = "";
    String lastName = "";
    String phoneNumber = "";
    String email = "";
    Scanner sc = new Scanner(System.in);
    String input = "";
    int index;

    /**
     * Print main menu
     */
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


    /**
     * Take name in upper or lower format and correct to capitalized readable format,
     * example:"daVid dRESden" out:"David Dresden"
     *
     * @param input take user input
     * @return name in readable format
     */
    public String nameFormatCorrector(String input) {
        String[] splitedInput = input.trim().split("\\s+");
        String result = splitedInput[0].substring(0, 1).toUpperCase() + splitedInput[0].substring(1).toLowerCase();
        for (int i = 1; i < splitedInput.length; i++) {
            result += " " + splitedInput[i].substring(0, 1).toUpperCase() + splitedInput[i].substring(1).toLowerCase();
        }
        return result;
    }

    /**
     * Get input from user for first name, if '0' return to main menu
     * @return checked first name in readable format
     */
    public String inputFirstName(){
        while(true){
            System.out.print("First name: ");
            input = sc.nextLine();
            returnToMainMenu();
            if (Validator.checkName(input)) {
                return nameFormatCorrector(input);
            }
        }
    }

    /**
     * Get input from user for last name, if '0' return to main menu
     * @return checked last name in readable format
     */
    public String inputLastName(){
        while(true){
            System.out.print("Last name: ");
            input = sc.nextLine();
            returnToMainMenu();
            if(Validator.checkName(input)){
                return nameFormatCorrector(input);
            }
        }
    }

    /**
     * Get input from user for phone number, if '0' return to main menu
     * @return checked phone number
     */
    public String inputPhoneNumber(){
        while(true){
            System.out.print("Phone number: ");
            input = sc.nextLine();
            returnToMainMenu();
            if(Validator.checkPhoneNumber(input)){
                return input;
            }
        }
    }

    /**
     * Get input from user for email, if '0' return to main menu
     * @return checked email
     */
    public String inputEmail(){
        while(true){
            System.out.print("Email: ");
            input = sc.nextLine();
            returnToMainMenu();
            if(Validator.checkEmail(input)){
                return input;
            }
        }
    }

    /**
     * Menu for contact creator, asking for contact fields while it's not valid, return checked
     * on '0' back to main menu
     * @return (first name, second name, phone number, email) som String[]
     */
    public String[] createMenu(){
        System.out.println("(press '0' for exit)");
        firstName = inputFirstName();
        lastName = inputLastName();
        phoneNumber = inputPhoneNumber();
        email = inputEmail();
        String[] data = new String[]{firstName, lastName, phoneNumber, email};
        return data;
    }

    /**
     * Menu for contact editor, asking for contact index in the list and all fields
     * while it's not valid, return checked
     * on '0' back to main menu
     * @param contactBook list with all contacts
     * @return (index, first name, second name, phone number, email) som String[]
     */
    public String[] editMenu(ContactBook contactBook){
        String[] data = new String[5];
        System.out.println();
        while(true) {
            System.out.print("Enter contact index (press '0' for exit): ");
            input = sc.nextLine();
            returnToMainMenu();
            if (input.matches("[0-9]+")) {
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

    /**
     * Menu for contact deleting, asking for contact index
     * while it's not valid
     * on '0' back to main menu
     * @param contactBook list with all contacts
     * @return contact index som int
     */
    public int deleteMenu(ContactBook contactBook){
        String[] data = new String[5];
        System.out.println();
        while(true) {
            System.out.print("Enter contact index (press '0' for exit): ");
            input = sc.nextLine();
            returnToMainMenu();
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

    /**
     * Menu for searching contact by any of fields editor
     * on '0' back to main menu
     * @return text to find
     */
    public String searchMenu() {
        System.out.print("Search (press '0' for exit): ");
        input = sc.nextLine();
        returnToMainMenu();
        return input;
    }

    /**
     * Menu for saving current contact book to json file
     * on '0' back to main menu
     * @return contact book name (filename without extension)
     */
    public String saveMenu() {
        System.out.print("Save contact book as (press '0' for exit): ");
        input = sc.nextLine();
        returnToMainMenu();
        return input.toLowerCase() + ".json";
    }

    /**
     * Menu for loading contact book from json file, show all exist
     * on '0' back to main menu
     * @return contact book index in the showing list as text
     */
    public String loadMenu() {
        FileOperations fileOperations = new FileOperations();
        List<String> contactBooks = fileOperations.getNamesOfContactBooks();
        int i = 0;
        for (String book : contactBooks) {
            System.out.println(++i + ". " + book);
        }
        do {
            System.out.print("\nChoose contact book (press '0' for exit): ");
            input = sc.nextLine();
            returnToMainMenu();
            if ((input.matches("[1-9]+")) && (Integer.parseInt(input) <= contactBooks.size())) {
                break;
            }
            System.out.println("invalid input, choose between " + 1 + " and " + contactBooks.size());
        } while (true);
        String contactBookName = contactBooks.get(Integer.parseInt(input) - 1);
        return contactBookName + ".json";
    }

    /**
     * return to main menu
     * @throws NullPointerException
     */
    public void returnToMainMenu() {
        if (input.equals("0")) {
            throw new NullPointerException();
        }
    }
}
