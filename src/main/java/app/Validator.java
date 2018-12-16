package app;

/**
 * Class check all user input
 * @author Maksym
 * @since 2018-12-01
 */

public class Validator {

    /**
     * check if name contains letters only
     *
     * @param input get input from user
     * @return true if name is valid, otherwise false
     */
    public static boolean checkName(String input){
        if (input.toLowerCase().matches("[a-z ]+")) {
            return true;
        }
        System.out.println("...invalid input, text only and start with uppercase, ex('Somename')");
        return false;
    }

    /**
     * check if phone number contains numbers only
     * @param input get input from user
     * @return true if phone number is valid, otherwise false
     */
    public static boolean checkPhoneNumber(String input){
        if (input.matches("[0-9]+")) {
            return true;
        }
        System.out.println("...invalid input, numbers only, min 7 characters ex(07533628)");
        return false;
    }

    /**
     * check if email has valid format
     * @param input get input from user
     * @return true if email is valid, otherwise false
     */
    public static boolean checkEmail(String input){
        if (input.toLowerCase().matches("[a-z0-9.-_+%]+[@][a-z]+[.][a-z]+")) {
            return true;
        }
        System.out.println("...invalid input, '@' and domain required, ex('max@mail.com')");
        return false;
    }
}
