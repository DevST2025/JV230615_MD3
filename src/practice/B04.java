package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B04 {
    public static void main(String[] args) {
        String sentence = "Rekkei Academy để nông dân biết code";

        List<String> stringList = new ArrayList<>(Arrays.asList(sentence.split(" ")));

        System.out.println("Original String: " + sentence);
        System.out.println("Strings with Length > 3:");

        for (String str : stringList) {
            if (str.length() > 3) {
                System.out.println(str);
            }
        }
    }
}
