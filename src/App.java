package src;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("> ");

        String string = scanner.nextLine().trim();

        if (string.isEmpty()) {
            System.err.println("The string cannot be empty!");

            scanner.close();

            return;
        }

        if (string.isBlank()) {
            System.err.println("The string cannot be blank!");

            scanner.close();

            return;
        }

        try {
            System.out.println("Result: " + convertFromBinaryToDecimal(string));
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }

        scanner.close();
    }

    public static String reverse(String string) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--) {
            stringBuilder.append(string.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static int convertFromBinaryToDecimal(String string) {
        for (int i = 0; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);

            if (currentCharacter != '0' && currentCharacter != '1') {
                throw new NumberFormatException();
            }
        }

        String reversedString = reverse(string);

        int result = 0;

        for (int i = 0; i < reversedString.length(); i++) {
            int numericValue = Character.getNumericValue(reversedString.charAt(i));

            result += numericValue * Math.pow(2, i);
        }

        return result;
    }
}
