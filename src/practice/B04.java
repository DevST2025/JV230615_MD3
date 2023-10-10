package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào 1 chuỗi: ");
        String inputData = sc.nextLine();
        String[] arrText = inputData.split("");

        List<Integer> listNumber = new ArrayList<>();
        for (int i = 0; i < arrText.length; i++) {
            try {
                listNumber.add(Integer.parseInt(arrText[i]));
            } catch (NumberFormatException e) {
                System.out.printf("Có kí tự thứ %d không phải số nguyên\n", i + 1);
                listNumber.add(0);
            }
        }
        System.out.print("Dãy số nguyên mới là: ");
        for (Integer i : listNumber) {
            System.out.print(i);
        }
    }
}
