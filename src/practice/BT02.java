package practice;

import java.util.Scanner;
import java.util.Stack;

public class BT02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập vào 1 chuỗi ký tự");
        String inputData = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputData.length(); i++) {
            char ch = inputData.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (inputData.isEmpty()) {
                    System.out.println("Không có ngoặc hợp lệ");
                    return;
                }
                char font = stack.pop();
                if (!isMatches(font, ch)) {
                    System.out.println("không có cặp ngoặc1");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Có các cặp ngoặc hợp lệ");
        } else {
            System.out.println("không có cặp ngoặc hợp lệ");
        }
    }

    public static boolean isMatches (char font, char back) {
        return (font == '(' && back == ')') ||
                (font == '{' && back == '}') ||
                (font == '[' && back == ']');
    }
}
