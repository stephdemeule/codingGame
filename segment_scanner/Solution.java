package segment_scanner;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String line1 = " _     _  _     _  _  _  _  _ ";
        String line2 = "| |  | _| _||_||_ |_   ||_||_|";
        String line3 = "|_|  ||_  _|  | _||_|  ||_| _|";

        StringBuilder result = new StringBuilder();

        int digitNumber = line1.length() / 3;

        String[] numbersReceived = new String[digitNumber];

        for (int i = 0; i < digitNumber; i++) {
            numbersReceived[i] = line1.substring(i * 3, i * 3 + 3) +
            line2.substring(i * 3, i * 3 + 3) +
            line3.substring(i * 3, i * 3 + 3);
        }

        for(String number : numbersReceived) {
            String n = getDigitFromPattern(number);
            result.append(n);
        }

        System.out.println(result);


    }

    private static String getDigitFromPattern(String number) {
        String[][] digitPatterns = {
                {" _ ", "| |", "|_|"}, // 0
                {"   ", "  |", "  |"}, // 1
                {" _ ", " _|", "|_ "}, // 2
                {" _ ", " _|", " _|"}, // 3
                {"   ", "|_|", "  |"}, // 4
                {" _ ", "|_ ", " _|"}, // 5
                {" _ ", "|_ ", "|_|"}, // 6
                {" _ ", "  |", "  |"}, // 7
                {" _ ", "|_|", "|_|"}, // 8
                {" _ ", "|_|", " _|"}  // 9
        };

        for(int i = 0; i < digitPatterns.length; i++) {
            if(number.equals(digitPatterns[i][0] + digitPatterns[i][1] + digitPatterns[i][2])) {
                return String.valueOf(i);
            }
        }
        return null;
    }
}
