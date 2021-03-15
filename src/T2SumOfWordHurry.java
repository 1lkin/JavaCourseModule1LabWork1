//      Count the LINES where the word "Harry" is met

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class T2SumOfWordHurry {
    public static void main(String[] args) throws IOException {

        String harry = new String(Files.readAllBytes(Paths
                .get("D:\\Java\\firstLabW\\src\\harry.txt")));
        harry = harry.replaceAll("[^a-zA-Z0-9'\\n ]", "");

        String[] harryWords = harry.split("\\n");

        int sum = 0;
//        Count the word "Harry"
        for (String harryWord : harryWords) {
            if (harryWord.contains("Harry")) {
                sum++;
            }
        }
        System.out.println("Number of the line with the word \"Harry\" is met " + sum + " times");
    }
}
