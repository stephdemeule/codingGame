package encryptiondecryption_of_enigma_machine;

import java.io.File;
import java.io.IOException;
import java.util.*;


class Solution {

    public static void main(String args[]) throws IOException {
        String path = "test2.txt";
        Scanner in = new Scanner(new File(path));


        String operation = in.nextLine();
        int pseudoRandomNumber = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }

        String[] rotors = new String[3];
        for (int i = 0; i < 3; i++) {
            rotors[i] = in.nextLine();
        }
        String message = in.nextLine();
        String result = "";


        if (operation.equals("ENCODE")) {
            result = caesarEncrypt(message, pseudoRandomNumber);
            for (int i = 0; i < 3; i++) {
                result = rotorEncrypt(result, rotors[i]);
            }
        }

        if (operation.equals("DECODE")) {
            result = message;
            for (int i = 2; i >= 0; i--) {
                result = rotorDecrypt(result, rotors[i]);
            }
            result = caesarDecrypt(result, pseudoRandomNumber);

        }


        System.out.println(result);
    }

    private static String caesarDecrypt(String message, int pseudoRandomNumber) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            int shift = (pseudoRandomNumber + i) % 26;
            int charPos = (currentChar - 'A' - shift + 26) % 26;
            char decryptedChar = (char) (charPos + 'A');

            encryptedMessage.append(decryptedChar);
        }
        return encryptedMessage.toString();
    }

    private static String rotorDecrypt(String message, String rotor) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            int charPos = rotor.indexOf(currentChar);
            decryptedMessage.append((char) ('A' + charPos));
        }
        return decryptedMessage.toString();
    }

    private static String rotorEncrypt(String message, String rotor) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int currentChar = message.charAt(i) - 'A';
            char encryptedChar = (char) rotor.charAt(currentChar);
            encryptedMessage.append(encryptedChar);
        }

        return encryptedMessage.toString();
    }

    private static String caesarEncrypt(String message, int pseudoRandomNumber) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            char encryptedChar = (char) ('A' + (currentChar - 'A' + (pseudoRandomNumber + i)) % 26);

            encryptedMessage.append(encryptedChar);
        }
        return encryptedMessage.toString();
    }
}
