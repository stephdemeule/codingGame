package anagram_to_break_the_code;

import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        // Lire le fichier d'entrée
        String path = "test4.txt";
        Scanner in = new Scanner(new File(path));
        String w = in.nextLine().toLowerCase(); // On met directement en minuscules
        String s = in.nextLine().toLowerCase();

        String result;

        String[] words = s.split("\\W+");

        int anagramPosition = -1;
        int digit3 = 0;
        int totalLength = 0;

        // Trouver la position de l'anagramme et calculer les longueurs nécessaires
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isAnagram(w, word)) {
                anagramPosition = i;
                break;
            }
            digit3 += word.length();  // Accumuler la longueur avant l'anagramme
        }

        if (anagramPosition == -1) {
            result = "Impossible";
        } else {
            int digit2 = words.length - 1 - anagramPosition;
            for (int i = anagramPosition + 1; i < words.length; i++) {
                totalLength += words[i].length();
            }
            int digit4 = totalLength % 10;

            result = anagramPosition % 10 + "." + digit2 % 10 + "." + digit3 % 10 + "." + digit4;
        }

        System.out.println(result);
    }

    private static boolean isAnagram(String w, String word) {
        if (w.length() != word.length() || w.equals(word)) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : w.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) - 1);
            if (charCount.get(c) == 0) {
                charCount.remove(c);
            }
        }

        return charCount.isEmpty();
    }
}
