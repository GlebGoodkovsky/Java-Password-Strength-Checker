import java.util.Scanner;

/**
 * PasswordStrengthChecker — analyzes the strength of a user-entered password.
 * Provides a single score and tips to improve if weak.
 */
public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);                   // Create Scanner for input
        System.out.print("Enter a password to check: ");           // Prompt user to enter password
        String password = scanner.nextLine();                       // Read entire line as password
        checkPasswordStrength(password);                            // Check and display password strength
    }

    /**
     * Analyzes password strength, prints score, and gives improvement tips if needed.
     */
    public static void checkPasswordStrength(String pwd) {
        boolean hasUpper = false;     // Flag for uppercase characters found
        boolean hasLower = false;     // Flag for lowercase characters found
        boolean hasDigit = false;     // Flag for digit characters found
        boolean hasSymbol = false;    // Flag for symbol characters found

        // Check each character in the password
        for (int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);

            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSymbol = true;      // Anything else counts as symbol
        }

        // Calculate the overall strength score as a percentage
        double score = calculateStrengthScore(pwd, hasUpper, hasLower, hasDigit, hasSymbol);
        int percentage = (int) Math.round(score);
        System.out.println("Password Strength Score: " + percentage + "%");

        // Show checks for each feature with emojis
        System.out.println("hasUpper: " + hasUpper + " " + checkmark(hasUpper));
        System.out.println("hasLower: " + hasLower + " " + checkmark(hasLower));
        System.out.println("hasDigit: " + hasDigit + " " + checkmark(hasDigit));
        System.out.println("hasSymbol: " + hasSymbol + " " + checkmark(hasSymbol));

        // Provide length feedback with emojis and messages
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

        // Determine if password is strong or weak based on criteria
        boolean strong = length >= 8 && hasUpper && hasLower && hasDigit && hasSymbol;
        if (strong) {
            System.out.println("Password is STRONG.");
        } else {
            // If weak, display suggestions for missing character types and length
            System.out.println("Password is WEAK. Here are some tips to improve it:");
            if (length < 8) System.out.println("- Use at least 8 characters");
            if (!hasUpper) System.out.println("- Include uppercase letters");
            if (!hasLower) System.out.println("- Include lowercase letters");
            if (!hasDigit) System.out.println("- Include digits (0-9)");
            if (!hasSymbol) System.out.println("- Include symbols (!, @, #, etc.)");
        }
    }

    /**
     * Calculates strength score from password features and length.
     * Uses weighted points and normalizes to 0-100 scale.
     */
    public static double calculateStrengthScore(String pwd, boolean hasUpper, boolean hasLower, boolean hasDigit, boolean hasSymbol) {
        double score = 0;
        if (hasUpper) score += 1.5;                 // Points for uppercase
        if (hasLower) score += 1.5;                 // Points for lowercase
        if (hasDigit) score += 1.0;                 // Points for digits
        if (hasSymbol) score += 2.0;                // Points for symbols
        score += Math.min(pwd.length() / 2.0, 20); // Points for length (max 20)
        return Math.min(score * 5, 100);            // Normalize to 100 max
    }

    /**
     * Returns checkmark emoji if true, else cross emoji.
     */
    public static String checkmark(boolean condition) {
        return condition ? "✅" : "❌";
    }
}
