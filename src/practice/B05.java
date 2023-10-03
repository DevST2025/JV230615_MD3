package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B05 {
    public static void main(String[] args) {
        String sentence = "Viết chương trình tìm từ ngắn nhất trong câu";

        List<String> wordList = new ArrayList<>(Arrays.asList(sentence.split(" ")));

        List<String> shortestWords = new ArrayList<>();
        int shortestLength = Integer.MAX_VALUE;

        for (String word : wordList) {
            int length = word.length();
            if (length < shortestLength) {
                shortestWords.clear();
                shortestWords.add(word);
                shortestLength = length;
            } else if (length == shortestLength) {
                shortestWords.add(word);
            }
        }

        System.out.println("Sentence: " + sentence);
        System.out.println("Shortest Word(s): " + shortestWords);
    }

}
