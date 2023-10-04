package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 đoạn:");
        String inputText = sc.nextLine();
        String[] words = inputText.split(" ");
        List<String> result = Arrays.stream(words).filter(s->s.length() > 5).collect(Collectors.toList());
        if (result.isEmpty()) {
            System.out.println("Không có chữ nào hơn 5 kí tự");
        } else {
            System.out.println(result);
        }
    }
}
