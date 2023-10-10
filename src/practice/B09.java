package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        try {
            System.out.print("Nhập số Fibonacci thứ n: ");
            n = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập một số nguyên dương.");
            scanner.close();
            return;
        }

        if (n <= 0) {
            System.out.println("Lỗi: Số Fibonacci thứ n phải là một số nguyên dương.");
            scanner.close();
            return;
        }

        int result = calculateFibonacci(n);
        System.out.println("Số Fibonacci thứ " + n + " là: " + result);
        scanner.close();
    }

    public static int calculateFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }

        int fib1 = 1, fib2 = 1, fib = 0;
        for (int i = 3; i <= n; i++) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }
        return fib;
    }
}
