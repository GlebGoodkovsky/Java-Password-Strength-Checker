import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to check: ");
        String password = scanner.nextLine();

        // Call the method to check strength
        checkPasswordStrength(password);
    }

    // Method to check password strength
    public static void checkPasswordStrength(String pwd) {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        // Loop through each character in the password
        for (int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSymbol = true; // not letter or digit
            }
        }

        // Debug output (optional - remove if not needed)
        System.out.println("hasUpper: " + hasUpper);
        System.out.println("hasLower: " + hasLower);
        System.out.println("hasDigit: " + hasDigit);
        System.out.println("hasSymbol: " + hasSymbol);
        System.out.println("length: " + pwd.length());

        // Check if all conditions are met
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
}
