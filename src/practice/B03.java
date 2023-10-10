package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class B03 {
    public static void main(String[] args) {
        Object[] arr = {2, 4, 5, null, "alo"};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            try {
                sum += (int) arr[i];
            } catch (Exception e) {
                System.out.printf("Có phần tử thứ %d không phải số nguyên\n", i + 1);
            }
        }
        System.out.println("Tổng: " + sum);
    }
}
