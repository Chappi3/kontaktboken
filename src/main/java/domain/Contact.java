package domain;

import java.io.Serializable;

/**
 * Class containing all data about contact
 * @author Maksym
 * @since 2018-12-01
 */

public class Contact implements Serializable {
    /**
     * Fields
     *
     * @param firstName is contact first name
     * @param lastName is contact last name
     * @param phoneNumber is contact phone number
     * @param email is contact email
     * @param serialVersionUID is uniq number, Serializable interface required
     */
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private static final long serialVersionUID = 6841681686311138743L;

    /**
     * Constructor
     */
    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Make Contact comparable, possible use equals like on java object class
     * @param obj is contact instance
     * @return boolean
     */
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

    /**
     * standart java hash method
     * @return number
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(getEmail());
    }

    /**
     * Transform all contact data to readable format
     * @return contact info as text
     */
    @Override
    public String toString() {
        return "Name: " + getFirstName() + ' ' + getLastName() + '\n' +
                "Phone: " + getPhoneNumber() + '\n' +
                "Email: " + getEmail();
    }

    /**
     * Getters and setters, set and collect data for each contact field
     */
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
