package app;

/**
 * Class check all user input
 *
 * @author Maksym
 * @since 2018-12-01
 */

public class Validator {
    //Check first or last name
    public static boolean checkName(String input){
        if (input.toLowerCase().matches("[a-z ]+")) {
            return true;
        }
        System.out.println("...invalid input, text only and start with uppercase, ex('Somename')");
        return false;
    }

    //Check phone number (numbers only)
    public static boolean checkPhoneNumber(String input){
        if (input.matches("[0-9]+")) {
            return true;
        }
        System.out.println("...invalid input, numbers only, min 7 characters ex(07533628)");
        return false;
    }

    //Check emil (ex. "one.team@gmail.com")
    public static boolean checkEmail(String input){
        if (input.toLowerCase().matches("[a-z0-9.-_+%]+[@][a-z]+[.][a-z]+")) {
            return true;
        }
        System.out.println("...invalid input, '@' and domain required, ex('max@mail.com')");
        return false;
    }
}
