package practice;

import java.util.ArrayList;
import java.util.List;

public class B02 {
    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);
        originalList.add(4);
        originalList.add(5);

        List<Integer> reversedList = new ArrayList<>();

        for (int i = originalList.size() - 1; i >= 0; i--) {
            reversedList.add(originalList.get(i));
        }

        System.out.println("Original List: " + originalList);
        System.out.println("Reversed List: " + reversedList);
    }
}
