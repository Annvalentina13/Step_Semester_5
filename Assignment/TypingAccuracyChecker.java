import java.util.Scanner;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // Handle extra characters if lengths are different
        int totalCharacters = Math.max(original.length(), typed.length());

        double accuracy = (matched * 100.0) / totalCharacters;

        System.out.println("Matched: " + matched + "/" + totalCharacters);
        System.out.printf("Accuracy: %.2f%%%n", accuracy);

        if (firstMismatch == -1) {

            if (original.length() == typed.length()) {
                System.out.println("No Mismatches");
            } else {
                System.out.println(
                        "Mismatch due to different string lengths"
                );
            }

        } else {

            char originalChar = original.charAt(firstMismatch);
            char typedChar = typed.charAt(firstMismatch);

            System.out.println(
                    "First Mismatch at position "
                            + (firstMismatch + 1)
                            + " ('"
                            + originalChar
                            + "' vs '"
                            + typedChar
                            + "')"
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}