package bulk_email_generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "test5.txt";
        Scanner in = new Scanner(new File(filePath));
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < N; i++) {
            text.append(in.nextLine()).append("\n");
        }

        String inputText = text.toString();
        Pattern pattern = Pattern.compile("\\(([^)]*)\\)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(inputText);

        int choiceNumber = 0;
        ArrayList<String> selectedClauses = new ArrayList<>();

        while (matcher.find()) {
            String choice = matcher.group(1);
            String[] clauses = choice.split("\\|", -1);
            String selectedClause = clauses[choiceNumber % clauses.length];
            selectedClauses.add(selectedClause);
            choiceNumber++;
        }

        matcher.reset();
        String result = inputText;
        int j = 0;
        while (matcher.find()) {
            String choice = matcher.group(1);
            String selectedClause = selectedClauses.get(j);
            result = result.replaceFirst(Pattern.quote("(" + choice + ")"), Matcher.quoteReplacement(selectedClause));
            j++;
        }

        System.out.println(result);
    }
}
