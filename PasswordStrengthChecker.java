import java.util.Scanner;  // Import Scanner class to read user input

public class PasswordStrengthChecker {

    // Main method - program entry point
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create Scanner object for input
        System.out.print("Enter a password to check: ");  // Prompt user for password
        String password = scanner.nextLine();  // Read password from user input
        checkPasswordStrength(password);  // Call method to check password strength
    }

    // Method to check the strength of the password
    public static void checkPasswordStrength(String pwd) {
        // Variables to keep track of password features
        boolean hasUpper = false;  // Does password have uppercase letters?
        boolean hasLower = false;  // Does password have lowercase letters?
        boolean hasDigit = false;  // Does password have digits (0-9)?
        boolean hasSymbol = false; // Does password have special symbols?

        // Loop through each character in the password string
        for (int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);  // Get character at position i

            // Check character type and update variables accordingly
            if (Character.isUpperCase(ch)) {
                hasUpper = true;  // Found uppercase letter
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;  // Found lowercase letter
            } else if (Character.isDigit(ch)) {
                hasDigit = true;  // Found digit
            } else {
                hasSymbol = true; // Found symbol (not letter or digit)
            }
        }

        // Print out each condition and show ✅ if true, ❌ if false
        System.out.println("hasUpper: " + hasUpper + " " + checkmark(hasUpper));
        System.out.println("hasLower: " + hasLower + " " + checkmark(hasLower));
        System.out.println("hasDigit: " + hasDigit + " " + checkmark(hasDigit));
        System.out.println("hasSymbol: " + hasSymbol + " " + checkmark(hasSymbol));

        // Enhanced length output with different emojis and messages
        int length = pwd.length();
        String lengthEmoji;
        String lengthMessage;

        if (length <= 3) {
            lengthEmoji = "❌";
            lengthMessage = "Too short";
        } else if (length <= 7) {
            lengthEmoji = "⚠️";
            lengthMessage = "Weak length";
        } else if (length <= 11) {
            lengthEmoji = "✅";
            lengthMessage = "Good length";
        } else {
            lengthEmoji = "🎉";
            lengthMessage = "Excellent length";
        }

        System.out.println("length: " + length + " " + lengthEmoji + " (" + lengthMessage + ")");

        // Final decision: password must be at least 8 characters and have all features
        if (length >= 8 && hasUpper && hasLower && hasDigit && hasSymbol) {
            System.out.println("Password is STRONG.");
        } else {
            // If any condition is missing, print tips for improvement
            System.out.println("Password is WEAK.");
            System.out.println("Tips:");
            System.out.println("- Use at least 8 characters");
            System.out.println("- Include uppercase and lowercase letters");
            System.out.println("- Include digits and symbols (!, @, #, etc.)");
        }
    }

    // Helper method: returns checkmark emoji if true, cross emoji if false
    public static String checkmark(boolean condition) {
        return condition ? "✅" : "❌";
    }
}
