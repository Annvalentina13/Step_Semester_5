public class LoginSimulator {

    static void simulateLogin(String correctCode, String[] attempts) {

        boolean accessGranted = false;

        for (int i = 0; i < attempts.length; i++) {

            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                accessGranted = true;
                break;
            }
        }

        if (!accessGranted) {
            System.out.println("Access denied — all attempts used");
        }
    }

    public static void main(String[] args) {

        String[] attempts1 = {"0000", "1234", "9999"};
        simulateLogin("1234", attempts1);

        String[] attempts2 = {"1111", "2222", "3333"};
        simulateLogin("1234", attempts2);
    }
}