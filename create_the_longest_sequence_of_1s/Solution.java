package create_the_longest_sequence_of_1s;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String b = "111111101111111";

        char[] arr = b.toCharArray();
        int max = 0;
        int currentCount = 0;
        int lastZeroPos = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                currentCount++;
            } else {
                int leftCount = (lastZeroPos == -1) ? currentCount : i - lastZeroPos - 1;
                int total = currentCount + leftCount + 1;
                if (total > max) {
                    max = total;
                }
                lastZeroPos = i;
                currentCount = 0;
            }
        }

        if (currentCount + lastZeroPos + 1 > max) {
            max = currentCount + lastZeroPos + 1;
        }

        System.out.println(max);
    }
}