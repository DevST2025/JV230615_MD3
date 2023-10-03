package practice;

import java.util.Scanner;
import java.util.Stack;

public class BT04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number :");
        int nums = scanner.nextInt();
        scanner.nextLine();

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < nums; i++) {
            System.out.println("Enter word " + (i + 1) + ": ");
            String word = scanner.nextLine();
            stack.push(word);
        }

        System.out.println("Rverse: ");
        while (!stack.isEmpty()) {
            String word = stack.pop();
            System.out.println(word);
        }
    }
}
