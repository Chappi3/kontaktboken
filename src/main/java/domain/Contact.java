package domain;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lasttName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lasttName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

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
        return "Name: " + getFirstName() + ' ' + getLasttName() + '\n' +
               "phone: " + getPhoneNumber() + '\n' +
               "email: " + getEmail();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lastName;
    }

    public void setLasttName(String lasttName) {
        this.lastName = lasttName;
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
