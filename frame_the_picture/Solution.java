package frame_the_picture;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) throws FileNotFoundException {
        String path = "test1.txt";
        Scanner in = new Scanner(new File(path));

        //Scanner in = new Scanner(System.in);
        String framePattern = in.nextLine(); // the ASCII art pattern to use to frame the picture
        StringBuilder reverseFramePattern = new StringBuilder(framePattern).reverse();
        int h = in.nextInt(); // the height of the picture
        int w = in.nextInt(); // the width  of the picture
        if (in.hasNextLine()) {
            in.nextLine();
        }

        List<String> frame = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            String line = in.nextLine();
            if(line.length() < w){
                line = line + " ".repeat(w - line.length());
            }
            frame.add(framePattern + " " + line + " " + reverseFramePattern); // the ASCII art picture line by line
        }


        int wFrame = frame.get(0).length();

        String top = "";
        List<String> topS = new ArrayList<>();
        for(int i = 0; i < framePattern.length(); i++) {
           String test = "";
            for(int j = 0; j<= i ; j++) {
                test += framePattern.charAt(j);
            }
            StringBuilder end = new StringBuilder(test).reverse();
            test += test.substring(test.length() - 1).repeat(wFrame - test.length()*2);
            test += end.toString();
            topS.add(test);
        }



        for(int i = 0; i < wFrame; i++) {
            top += framePattern;
        }
        if(top.length() > wFrame){
            top = top.substring(0,wFrame );
        }

        String border = framePattern + " ".repeat(w + 2) + reverseFramePattern;

        List<String> result = new ArrayList<>(topS);
        result.add(border);
        result.addAll(frame);
        result.add(border);
        for (int i = topS.size()-1;  i >= 0 ; i--) {
            result.add(topS.get(i));
        }


        for (String line : result) {
            System.out.println(line);
        }
    }
}