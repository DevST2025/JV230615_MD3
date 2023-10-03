package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int maxLength = 10; // Maximum number of elements in the list

        int length = (int) (Math.random() * maxLength) + 1; // Random length of the list

        for (int i = 0; i < length; i++) {
            int randomNumber = (int) (Math.random() * 100); // Generate random number between 0 and 99
            list.add(randomNumber);
        }

        System.out.println("Random List: " + list);

        int maxElement = Collections.max(list);
        System.out.println("Max Element: " + maxElement);
    }
}
