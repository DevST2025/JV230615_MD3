package practice;

import java.util.Scanner;
import java.util.Stack;

public class BT13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input String: ");
        String inputString = scanner.nextLine();
        System.out.println("Is Decreasing: " + checkDecreasing(inputString));
    }

    public static boolean checkDecreasing(String input) {
        Stack<Character> stack = new Stack<>();
        char previousChar = input.charAt(0);
        stack.push(previousChar);
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar > previousChar) {
                return false;
            }
            stack.push(currentChar);
            previousChar = currentChar;
        }
        return true;
    }
}
