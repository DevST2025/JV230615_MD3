package practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BT09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input size: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("input element " + (i + 1) + " :");
            arr[i] = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.println("Input String: ");
        String inputString = scanner.nextLine();
        reverseArray(arr);
        String outputString = reverseString(inputString);
        System.out.println("Reversed array: " + Arrays.toString(arr));
        System.out.println("Reversed string: " + outputString);
    }

    public static void reverseArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i :
                arr) {
            stack.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static String reverseString(String input) {
        Stack<Character> stack = new Stack<>();

        StringBuilder reverseStr = new StringBuilder();

        String[] words = input.split(" ");
        for (String word :
                words) {
            char[] chars = word.toCharArray();
            for (char c :
                    chars) {
                stack.push(c);
            }
            stack.push(' ');
        }

        while (!stack.isEmpty()) {
            char c = stack.pop();
            reverseStr.append(c);
        }

        return reverseStr.toString();
    }
}
