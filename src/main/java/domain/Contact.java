package domain;

public class Contact {
    //Fields
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    //Controller
    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Use equals for comparing Contact with another Contact
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
        return "Name: " + getFirstName() + ' ' + getLastName() + '\n' +
               "phone: " + getPhoneNumber() + '\n' +
               "email: " + getEmail();
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