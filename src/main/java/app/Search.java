package app;

import domain.ContactBook;

public class Search {

    public void searchName(String name, ContactBook contactBook) {
        /**
         * This will check if the contact book is empty or not
         * If it's not empty, then continue to check if first name is in contactBook
         */
        if(!contactBook.getContactBook().isEmpty()) {
            for(int i = 0; i < contactBook.getContactBook().size(); i++) {
                contactBook.getContactBook().get(i);
                if(contactBook.getContactBook().get(i).getFirstName().equals(name)) {
                    System.out.println(contactBook.getContactBook().get(i));
                    break;
                }
            }
        }else {
            System.out.println("There are no contacts in the contact book");
        }
    }

    public void searchLastName(String lastName, ContactBook contactBook) {
        /**
         * This will check if the contact book is empty or not
         * If it's not empty, then continue to check if last name is in contactBook
         */
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

    public void searchEmail(String email, ContactBook contactBook) {
        /**
         * This will check if the contact book is empty or not
         * If it's not empty, then continue to check if email is in contactBook
         */
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

    public void searchNumber(String number, ContactBook contactBook) {
        /**
         * This will check if the contact book is empty or not
         * If it's not empty, then continue to check if number is in contactBook
         */
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
