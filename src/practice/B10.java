package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class B10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Anh", "Bao", "Cuong", "Duy");
        List<String> convertString = list.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(convertString);
    }
}
