package practice;

import java.util.Arrays;
import java.util.List;

public class B09 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,2,43,2,5,54,32,1,9,10);
        long count = list.stream().filter(number -> number > 10).count();
        System.out.println(count);
    }
}
