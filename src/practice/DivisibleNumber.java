package practice;

import java.util.Scanner;

public class DivisibleNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số kiểm tra: ");
        int num = scanner.nextInt();
        String result = "";

        if (num % 3 == 0 && num % 5 == 0) {
            result = "Chia hết cho cả 3 và 5";
        } else if (num % 3 == 0) {
            result = "chia hết cho 3";
        } else if (num % 5 == 0) {
            result = "khum chia hết cho 3, cũng khum chia hết cho 5";
        }
        System.out.println(result);
    }
}
