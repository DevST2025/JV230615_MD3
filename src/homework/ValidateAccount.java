package homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public boolean validate(String account) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(account);
        return matcher.matches();
    }

    public static void main(String[] args) {
        ValidateAccount accountExample = new ValidateAccount();

        String[] validAccounts = {"123abc_", "_abc123", "______", "123456", "abcdefgh"};
        String[] invalidAccounts = {".@", "12345", "1234_", "abcde"};

        for (String account : validAccounts) {
            boolean isValid = accountExample.validate(account);
            System.out.println("Tài khoản " + account + " hơp lệ: " + isValid);
        }

        for (String account : invalidAccounts) {
            boolean isValid = accountExample.validate(account);
            System.out.println("Tài khoản " + account + " không hợp lệ: " + isValid);
        }
    }
}
