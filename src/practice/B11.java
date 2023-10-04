package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B11 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,2,5,7,12,8,3,9);
        List<Integer> oddList = list.stream().filter(i -> i%3 == 0).collect(Collectors.toList());
        int result = oddList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(result);
    }
}
