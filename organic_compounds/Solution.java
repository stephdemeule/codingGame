package organic_compounds;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws FileNotFoundException {
        String path = "test3.txt";
        Scanner in = new Scanner(new File(path));
        //Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        char[][] formula = new char[N][];
        for (int i = 0; i < N; i++) {
            String COMPOUND = in.nextLine();
            formula[i] = COMPOUND.toCharArray();
        }

        String result = "VALID";

        for(int i = 0; i < formula.length; i++) {
            for (int j = 0; j < formula[i].length; j++) {
                if(formula[i][j] == 'C') {
                   int liaisons = calculateLiaisons(formula, i, j);
                   int hydrogens = calculateHydrogens(formula, i, j);
                   if( liaisons + hydrogens != 4) {
                       result = "INVALID";
                       break;
                   }
                }
            }
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result);
    }

    private static int calculateLiaisons(char[][] formula, int i, int j) {
        int liaisons = 0;
        if(j > 2 && formula[i][j-2] != ' ') {
            liaisons += Integer.parseInt(String.valueOf(formula[i][j-2]));
        }
        if(j < formula[i].length - 4 && formula[i][j+4] != ' ') {
            liaisons += Integer.parseInt(String.valueOf(formula[i][j+4]));
        }
        if(i > 1 && formula[i-1].length > j && formula[i-1][j] == '(') {
            liaisons += Integer.parseInt(String.valueOf(formula[i-1][j+1]));
        }
        if(i < formula.length -1 && formula[i+1].length > j && formula[i+1][j] == '(') {

            liaisons += Integer.parseInt(String.valueOf(formula[i+1][j+1]));
        }
        return liaisons;
    }

    private static int calculateHydrogens(char[][] formula, int i, int j) {
        return Integer.parseInt(String.valueOf(formula[i][j+2]));
    }
}
