package app;

import domain.ContactBook;

/**
 * This class will search through an array (contact book) and display the contact if it exists.
 *
 * @author Ilari Silander
 * @version 1.0
 * @since 2018-12-12
 */

public class Search {

    /**
     * This method uses a String parameter and compares it to all the methods.
     *
     * @param find This parameter is the input from the menu
     * @param contactBook This parameter is the arrayList that we send to all the methods
     */

    public static void search(String find, ContactBook contactBook) {
        //Checks if the arrayList is empty or not
        if(!contactBook.getContactBook().isEmpty()) {
            searchName(find, contactBook);
            searchLastName(find, contactBook);
            searchNumber(find, contactBook);
            searchEmail(find, contactBook);
        }else {
            System.out.println("There are no contacts in the contact book.");
        }
    }

    /**
     * This method will take a first name of a contact, and search through a contact book (arrayList).
     * If the name matches a contact in the contact book, then the contact gets printed to console.
     *
     * @param name This parameter is the string that the method will compare.
     * @param contactBook This parameter is the arrayList that we will search through
     */

    public static void searchName(String name, ContactBook contactBook) {

        //If the arrayList has a contact then it will loop through the list
        for(int i = 0; i < contactBook.getContactBook().size(); i++) {
            contactBook.getContactBook().get(i);
            //This checks every contact and compares the parameters, if equal, then the contact gets printed
            if(contactBook.getContactBook().get(i).getFirstName().equalsIgnoreCase(name)) {
                System.out.println("Index: " + (i + 1));
                System.out.println(contactBook.getContactBook().get(i));
            }
        }

    }

    /**
     * This method will take the last name of a contact, and search through a contact book (arrayList).
     * If the last name matches a contact in the contact book, then the contact gets printed to console.
     *
     * @param lastName This parameter is the string that the method will compare.
     * @param contactBook This parameter is the arrayList that we will search through
     */

    public static void searchLastName(String lastName, ContactBook contactBook) {
        for(int i = 0; i < contactBook.getContactBook().size(); i++) {
            contactBook.getContactBook().get(i);
            if(contactBook.getContactBook().get(i).getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Index: " + (i + 1));
                System.out.println(contactBook.getContactBook().get(i));
            }
        }

    }

    /**
     * This method will take the e-mail of a contact, and search through a contact book (arrayList).
     * If the e-mail matches a contact in the contact book, then the contact gets printed to console.
     *
     * @param email This parameter is the string that the method will compare.
     * @param contactBook This parameter is the arrayList that we will search through
     */

    public static void searchEmail(String email, ContactBook contactBook) {
        for(int i = 0; i < contactBook.getContactBook().size(); i++) {
            contactBook.getContactBook().get(i);
            if(contactBook.getContactBook().get(i).getEmail().equalsIgnoreCase(email)) {
                System.out.println("Index: " + (i + 1));
                System.out.println(contactBook.getContactBook().get(i));
            }
        }

    }

    /**
     * This method will take the phone number of a contact, and search through a contact book (arrayList).
     * If the phone number matches a contact in the contact book, then the contact gets printed to console.
     *
     * @param number This parameter is the string that the method will compare.
     * @param contactBook This parameter is the arrayList that we will search through
     */

    public static void searchNumber(String number, ContactBook contactBook) {

        for(int i = 0; i < contactBook.getContactBook().size(); i++) {
            contactBook.getContactBook().get(i);
            if(contactBook.getContactBook().get(i).getPhoneNumber().equals(number)) {
                System.out.println("Index: " + (i + 1));
                System.out.println(contactBook.getContactBook().get(i));
            }
        }

    }

}
