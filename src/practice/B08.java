package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        try {
            System.out.print("Nhập một số nguyên dương: ");
            number = scanner.nextInt();

            if (number < 2) {
                System.out.println("Số phải lớn hơn hoặc bằng 2 để là số nguyên tố.");
            } else if (isPrime(number)) {
                System.out.println(number + " là số nguyên tố.");
            } else {
                System.out.println(number + " không là số nguyên tố.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn đã nhập không phải là một số nguyên.");
        } finally {
            scanner.close();
        }
    }

    // Phương thức kiểm tra xem một số có phải là số nguyên tố hay không
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
