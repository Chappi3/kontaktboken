package app;

public class Validator {
    //Check first or last name (text only and start with uppercase, ex. "Daniel")
    public static boolean checkName(String input){
        if(input.matches("[A-Z]{1}[a-z]{2,20}")){
            return true;
        }
        return false;
    }

    
}
