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
     * This method will take a first name of a contact, and search through a contact book (arrayList).
     * If the name matches a contact in the contact book, then the contact gets printed to console.
     *
     * @param name This parameter is the string that the method will compare.
     * @param contactBook This parameter is the arrayList that we will search through
     */

    public void searchName(String name, ContactBook contactBook) {
        //Checks if the arrayList is empty or not
        if(!contactBook.getContactBook().isEmpty()) {
            //If the arrayList has a contact then it will loop through the list
            for(int i = 0; i < contactBook.getContactBook().size(); i++) {
                contactBook.getContactBook().get(i);
                //This checks every contact and compares the parameters, if equal, then the contact gets printed
                if(contactBook.getContactBook().get(i).getFirstName().equals(name)) {
                    System.out.println(contactBook.getContactBook().get(i));
                    break;
                }
            }
        }else {
            System.out.println("There are no contacts in the contact book");
        }
    }

    /**
     * This method will take the last name of a contact, and search through a contact book (arrayList).
     * If the last name matches a contact in the contact book, then the contact gets printed to console.
     *
     * @param lastName This parameter is the string that the method will compare.
     * @param contactBook This parameter is the arrayList that we will search through
     */

    public void searchLastName(String lastName, ContactBook contactBook) {
        if(!contactBook.getContactBook().isEmpty()) {
            for(int i = 0; i < contactBook.getContactBook().size(); i++) {
                contactBook.getContactBook().get(i);
                if(contactBook.getContactBook().get(i).getLastName().equals(lastName)) {
                    System.out.println(contactBook.getContactBook().get(i));
                    break;
                }
            }
        }else {
            System.out.println("There are no contacts in the contact book");
        }
    }

    /**
     * This method will take the e-mail of a contact, and search through a contact book (arrayList).
     * If the e-mail matches a contact in the contact book, then the contact gets printed to console.
     *
     * @param email This parameter is the string that the method will compare.
     * @param contactBook This parameter is the arrayList that we will search through
     */

    public void searchEmail(String email, ContactBook contactBook) {
        if(!contactBook.getContactBook().isEmpty()) {
            for(int i = 0; i < contactBook.getContactBook().size(); i++) {
                contactBook.getContactBook().get(i);
                if(contactBook.getContactBook().get(i).getEmail().equals(email)) {
                    System.out.println(contactBook.getContactBook().get(i));
                    break;
                }
            }
        }else {
            System.out.println("There are no contacts in the contact book");
        }
    }

    /**
     * This method will take the phone number of a contact, and search through a contact book (arrayList).
     * If the phone number matches a contact in the contact book, then the contact gets printed to console.
     *
     * @param number This parameter is the string that the method will compare.
     * @param contactBook This parameter is the arrayList that we will search through
     */

    public void searchNumber(String number, ContactBook contactBook) {
        if(!contactBook.getContactBook().isEmpty()) {
            for(int i = 0; i < contactBook.getContactBook().size(); i++) {
                contactBook.getContactBook().get(i);
                if(contactBook.getContactBook().get(i).getPhoneNumber().equals(number)) {
                    System.out.println(contactBook.getContactBook().get(i));
                    break;
                }
            }
        }else {
            System.out.println("There are no contacts in the contact book");
        }
    }

}
