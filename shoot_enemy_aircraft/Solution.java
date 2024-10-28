package shoot_enemy_aircraft;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "test2.txt";
        Scanner in = new Scanner(new File(filePath));

        int n = in.nextInt();
        List<String> sky = new ArrayList<>();
        List<String> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = in.next();
            sky.add(line);
        }
        int gunPos = sky.get(n - 1).indexOf('^');
        int maxShoot = 0;

        for (int i = n - 2; i >= 0; i--) {
            System.out.println(sky.get(i));
            int index = 0;
            for (int j = gunPos - (n - i); j >= 0; j--) {
                results.add(index > results.size() ? results.get(index) : "WAIT");
                System.out.println(" i = " + i + " j = " + j);
                if (sky.get(i).charAt(j) == '>') {
                    results.set(index, "SHOOT");
                    maxShoot = Math.max(maxShoot, index);
                }
                index++;
            }

            index = 0;

            for (int j = gunPos + n - i; j < sky.get(i).length(); j++) {
                results.add(index > results.size() ? results.get(index) : "WAIT");
                if (sky.get(i).charAt(j) == '<') {
                    results.set(index, "SHOOT");
                    maxShoot = Math.max(maxShoot, index);

                }
                index++;
            }


        }
        // read results to maxShoot index
        for (int i = 0; i < maxShoot + 1; i++) {
            System.out.println(results.get(i).equals("SHOOT") ? "SHOOT" : "WAIT");
        }

    }
}