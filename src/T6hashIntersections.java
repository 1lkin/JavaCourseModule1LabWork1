//      Count the intersections of hashes

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class T6hashIntersections {
    public static void main(String[] args) throws IOException {

        String harry = new String(Files.readAllBytes(Paths
                .get("D:\\Java\\firstLabW\\src\\harry.txt")));
        harry = harry.replaceAll("[^a-zA-Z0-9' ]", "")
                .toLowerCase();

        String[] harryWords = harry.split(" ");
        Arrays.sort(harryWords);
        for (String harryWord : harryWords) {
            harryWord.trim();
        }

        int[] hashHarryWords = new int[harryWords.length];

//        Creating an array of hashes.
        for (int i = 0; i < hashHarryWords.length; i++) {
            hashHarryWords[i] = harryWords[i].hashCode();
//            System.out.println(hashHarryWords[i]);
        }

        int hashCountingIntersections = 1;
        for (int i = 0; i < hashHarryWords.length-1; i++) {
            if (hashHarryWords[i] == hashHarryWords[i+1]){
                hashCountingIntersections++;
            }
//            if (i == hashHarryWords.length-2){
//                if (hashHarryWords[i] == hashHarryWords[i+1]){
//                    hashCountingIntersections++;
//                }
//            }
        }
        System.out.println("There are " + hashCountingIntersections + " intersections");
    }
}