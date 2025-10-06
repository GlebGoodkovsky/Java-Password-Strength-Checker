import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to check: ");
        String password = scanner.nextLine();
        checkPasswordStrength(password);
    }

    public static void checkPasswordStrength(String pwd) {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        for (int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSymbol = true;
            }
        }

        System.out.println("hasUpper: " + hasUpper + " " + checkmark(hasUpper));
        System.out.println("hasLower: " + hasLower + " " + checkmark(hasLower));
        System.out.println("hasDigit: " + hasDigit + " " + checkmark(hasDigit));
        System.out.println("hasSymbol: " + hasSymbol + " " + checkmark(hasSymbol));
        System.out.println("length: " + pwd.length() + (pwd.length() >= 8 ? " ✅" : " ❌"));

        if (pwd.length() >= 8 && hasUpper && hasLower && hasDigit && hasSymbol) {
            System.out.println("Password is STRONG.");
        } else {
            System.out.println("Password is WEAK.");
            System.out.println("Tips:");
            System.out.println("- Use at least 8 characters");
            System.out.println("- Include uppercase and lowercase letters");
            System.out.println("- Include digits and symbols (!, @, #, etc.)");
        }
    }

    public static String checkmark(boolean condition) {
        return condition ? "✅" : "❌";
    }
}
