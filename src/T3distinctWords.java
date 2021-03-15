//      Take the array of distinct words from Harry Potter .

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class T3distinctWords {
    public static void main(String[] args) throws IOException {

        String harry = new String(Files.readAllBytes(Paths
                .get("D:\\Java\\firstLabW\\src\\harry.txt")));
        harry = harry.replaceAll("[^a-zA-Z0-9' ]", "").toLowerCase();

        String[] harryWords = harry.split(" ");
        Arrays.sort(harryWords);
        for (String harryWord : harryWords) {
            harryWord.trim();
        }

        int[] amountOfWord = new int[harryWords.length];

        int m;
        for (int j = 0; j < harryWords.length; j++) {
            m = 0;
            for (String harryWord : harryWords) {
                if (harryWords[j].equals(harryWord)) {
                    m++;
                }
            }
            amountOfWord[j] = m;
        }

        int n = 0;
        for (int i = 0; i < harryWords.length; i++) {
            if (amountOfWord[i] == 1){
                n++;
            }
        }

        int p = 0;
        String[] distinctWords = new String[n];
        for (int i = 0; i < harryWords.length; i++) {
            if (amountOfWord[i] == 1){
                distinctWords[p] = harryWords[i];
                p++;
            }
        }

        for (String distinctWord : distinctWords) {
            System.out.println(distinctWord);
        }
    }
}