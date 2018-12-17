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
     */
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private static final long serialVersionUID = 6841681686311138743L;

    /**
     * Constructor
     * @param firstName is contact first name
     * @param lastName is contact last name
     * @param phoneNumber is contact phone number
     * @param email is contact email
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
     * Get contact first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set value for contact first name
     *
     * @param firstName is first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get contact last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set value for contact last name
     * @param lastName is last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get contact phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set value for contact phone number
     * @param phoneNumber is phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get contact email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value for contact email
     * @param email is email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
