package domain;

import java.io.Serializable;

public class Contact implements Serializable {
    private String firstName;
    private String lasttName;
    private String phoneNumber;
    private String email;
    public static final long serialVersionUID = 44L;

    //Constructor
    public Contact(String firstName, String lasttName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Use equals if you want to compare Contact with another Contact
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
    @Override
    public int hashCode() {
        return java.util.Objects.hash(getEmail());
    }
    @Override
    public String toString() {
        return getEmail();
    }

    //Getters & Setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLasttName() {
        return lasttName;
    }
    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
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
