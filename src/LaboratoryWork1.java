/**
 * Ilkin Hasanov
 * <p>
 * Copyright (c) HASANOV.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * IKIN HASANOV's response to "Laboratory Work No.1", Module 1.
 *
 *   Task:
 *      1. Find the longest word in the above text.
 *      2. Count the LINES where the word "Harry" is met.
 *      3. Take  the array of distinct words from Harry Potter.
 *      4. How many distinct words begin from the letter "C".
 *      5. Create an array of hashes.
 *      6. Count the intersections of hashes.
 *
 * @version 1.10 14-03-2021
 * @author Ilkin Hasanov
 */

public class LaboratoryWork1 {
    public static void main(String[] args) throws IOException {
//      Declaration of String and initialization with the content
//                            of the text document "Harry Potter"
        String harry = new String(Files.readAllBytes(Paths
                .get("src\\harry.txt")));

//      Removing all punctuation signs except single quote,
//      replacing capital letters with lowercase letters
        harry = harry.replaceAll("[^a-zA-Z0-9' ]", "").toLowerCase()
                .replaceAll(" '", "").replaceAll("' ", "");
//      reducing all excess spaces
        while (harry.contains("  ")) {
            harry = harry.replaceAll("  ", " ");
        }

//      Splitting the novel into an array of words
        String[] harryWords = harry.split(" ");

//      1. Find the longest word in the text.
        String temp = "";
        for (String harryWord : harryWords) {
            if (harryWord.length() > temp.length()) {
                temp = harryWord;
            }
        }
        System.out.println("The longest word is: " + temp);

//      2. Count the LINES where the word "Harry" is met.
        String harryLines = new String(Files.readAllBytes(Paths
                .get("src\\harry.txt")));
        harryLines = harryLines.replaceAll("[^a-zA-Z0-9'\\n ]", "");

        String[] harryLinesWords = harryLines.split("\\n");

        int sum = 0;
//      Counting the lines with word "Harry"
        for (String harryLinesWord : harryLinesWords) {
            if (harryLinesWord.contains("Harry")) {
                sum++;
            }
        }
        System.out.println("Number of the line with the word \"Harry\" is met " + sum + " times");

//      3. Take  the array of distinct words from Harry Potter
        String[] distinctWordsOfHarry = Arrays.stream(harryWords)
                .distinct().toArray(String[]::new);

//      System.out.println(Arrays.toString(distinctWordsOfHarry));

//      4. How many distinct words begin from the letter "C"
        int wordWithC = 0;
        for (int z = 0; z < distinctWordsOfHarry.length; z++) {
            if (distinctWordsOfHarry[z].charAt(0) == 'c') {
                wordWithC++;
            }
        }
        System.out.println("There are " + wordWithC +
                " distinct words begin with the letter \"C\"");

//      5. Create an array of hashes
        int[] hashHarryWords = new int[harryWords.length];
        for (int i = 0; i < hashHarryWords.length; i++) {
            hashHarryWords[i] = harryWords[i].hashCode();
        }

//      6. Count the intersections of hashes
        int hashCountingIntersections = 1;
        for (int i = 0; i < hashHarryWords.length-1; i++) {
            if (hashHarryWords[i] == hashHarryWords[i+1]){
                hashCountingIntersections++;
            }
        }
    }
}