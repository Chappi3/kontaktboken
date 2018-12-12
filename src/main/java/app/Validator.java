package app;

/**
 * @author Maksym Gorbunov
 */

public class Validator {
    //Check first or last name (text only and start with uppercase, ex. "Daniel")
    public static boolean checkName(String input){
        if (input.matches("[A-Z]{1}[a-z]{2,20}") ||
                input.matches("[A-Z]{1}[a-z]{2,20}[ ][A-Z]{1}[a-z]{2,20}")) {
            return true;
        }
        System.out.println("...invalid input, text only and start with uppercase, ex('Somename')");
        return false;
    }

    //Check phone number (numbers only)
    public static boolean checkPhoneNumber(String input){
        if(input.matches("[0-9]{7,15}")){
            return true;
        }
        System.out.println("...invalid input, numbers only, min 7 characters ex(07533628)");
        return false;
    }

    //Check emil (ex. "one.team@gmail.com")
    public static boolean checkEmail(String input){
        if (input.matches("[A-Za-z0-9.-_]{1,30}[@][a-z]{2,10}[.][a-z]{2,10}")) {
            return true;
        }
        System.out.println("...invalid input, '@' and domain required, ex('max@mail.com')");
        return false;
    }
}
