package practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BT11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input size: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        scanner.nextLine();
        for (int i = 0; i < size; i++) {
            System.out.println("Element # " + (i + 1) + " : ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Input array: " + Arrays.toString(arr));
        System.out.println("Max value is: " + findMaxElement(arr));
    }

    public static int findMaxElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i :
                arr) {
            if (stack.isEmpty() || i > stack.peek()) {
                stack.push(i);
            }
        }
        return stack.peek();
    }
}
