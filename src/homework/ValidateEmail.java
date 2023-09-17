package homework;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String email = "example@example.com";
        if (isValidEmail(email)) {
            System.out.println("Email is valid.");
        } else {
            System.out.println("Email is invalid.");
        }
    }
}
