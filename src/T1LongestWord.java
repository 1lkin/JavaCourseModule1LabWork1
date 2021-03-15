//      Find the longest word in the text.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class T1LongestWord {
    public static void main(String[] args) throws IOException {

        String harry = new String(Files.readAllBytes(Paths
                .get("D:\\Java\\firstLabW\\src\\harry.txt")));
        harry = harry.replaceAll("[^a-zA-Z0-9' ]", "");

        String[] harryWords = harry.split(" ");


        String temp = "";
        for (String harryWord : harryWords) {
            if (harryWord.length() > temp.length()) {
                temp = harryWord;
            }
        }
        System.out.println("The longest word is: " + temp);
    }
}

