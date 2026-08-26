public class ATM {

    static void atmPinRetry(String correctPin, String[] attempts) {

        int attemptCount = 0;
        boolean success = false;

        while (attemptCount < attempts.length && !success) {

            if (attempts[attemptCount].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }

            attemptCount++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {

        String[] attempts1 = {"1111", "4821"};
        atmPinRetry("4821", attempts1);

        String[] attempts2 = {"1111", "2222", "3333"};
        atmPinRetry("4821", attempts2);
    }
}