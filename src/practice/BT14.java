package practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BT14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input size: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("input element # " + (i + 1) + " :");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Is prime numbers: " + checkPrimeNumbers(arr));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPrimeNumbers(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        while (!stack.isEmpty()) {
            int number = stack.pop();
            if (!isPrime(number)) {
                return false;
            }
        }
        return true;
    }
}
