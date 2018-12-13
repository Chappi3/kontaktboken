package domain;

import java.io.Serializable;

/**
 * Class consisting all contact data
 *
 * @author Maksym
 * @since 2018-12-01
 */

public class Contact implements Serializable {
    //Serializable interface required
    private static final long serialVersionUID = 6841681686311138743L;
    //Fields
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    //Constructor
    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Use equals for comparing Contact with another Contact, email uniq
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Contact obj2 = (Contact) obj;
        return getEmail().equals(obj2.getEmail());
    }

    //make possibility to compare contact as java object
    @Override
    public int hashCode() {
        return java.util.Objects.hash(getEmail());
    }

    //return contact info in readable format
    @Override
    public String toString() {
        return "Name: " + getFirstName() + ' ' + getLastName() + '\n' +
                "Phone: " + getPhoneNumber() + '\n' +
                "Email: " + getEmail();
    }

    //Getters & setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
