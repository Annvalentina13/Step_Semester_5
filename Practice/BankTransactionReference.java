import java.util.Scanner;

public class BankTransactionReference {

    static String normalizeReference(String raw) {

        // Remove leading and trailing spaces
        String reference = raw.trim();

        // If less than 3 characters, return as it is
        // Validation will handle the length error
        if (reference.length() < 3) {
            return reference;
        }

        // Convert only first 3 characters to uppercase
        String bankCode = reference.substring(0, 3).toUpperCase();
        String remaining = reference.substring(3);

        return bankCode + remaining;
    }

    static String validateAndFormat(String reference) {

        // Step 1: Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Step 2: Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Step 3: Check remaining 11 characters are digits
        for (int i = 3; i < reference.length(); i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Extract bank code
        String bankCode = reference.substring(0, 3);

        // Extract date components
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);

        // Extract sequence number
        String sequence = reference.substring(9, 14);

        // Build formatted output
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");
        result.append(day);
        result.append("/");
        result.append(month);
        result.append("/");
        result.append(year);
        result.append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String normalized = normalizeReference(raw);

        String result = validateAndFormat(normalized);

        System.out.println(result);

        sc.close();
    }
}