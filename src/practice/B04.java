package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class B04 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,2,4,7,5,86,32,45);
        List<Integer> result = numbers.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println(result);
    }
}
