package caesar_is_the_chief;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws FileNotFoundException {

        String path = "test.txt";
        Scanner in = new Scanner(new File(path));
        // Scanner in = new Scanner(System.in);
        String textToDecode = in.nextLine();

        String[] words = textToDecode.split(" ");

        int shift = 100;

        String message = "WRONG MESSAGE";

        for (String word : words) {
            shift = caesarShift(word);
            if (shift != 100) {
                break;
            }
        }

        if (shift != 100) {
            message = caesarDecrypt(textToDecode, shift);
        }


        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(message);
    }

    private static int caesarShift(String word) {
        int shift = 100;
        if (word.length() == 5
                && word.charAt(1) == word.charAt(0) + 5
                && word.charAt(2) == word.charAt(0) + 6
                && word.charAt(3) == word.charAt(0) + 2
                && word.charAt(4) == word.charAt(0) + 3) {
            return word.charAt(0) - 'C';
        } else {
            return shift;
        }
    }

    private static String caesarDecrypt(String message, int shift) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char decryptedChar = ' ';
            char currentChar = message.charAt(i);
            if (currentChar != ' ') {
                decryptedChar = (char) ((currentChar - 'A' - shift + 26) % 26 + 'A');
            }

            decryptedMessage.insert(i, decryptedChar);
        }
        return decryptedMessage.toString();
    }
}
