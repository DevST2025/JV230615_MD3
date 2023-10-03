package practice;

import java.util.Stack;

public class BT06 {
    public static void main(String[] args) {
        String expression1 = "s * (s - a) * (s - b) * (s - c)";
        String expression2 = "(-- b + (b2 - 4*a*c)^0.5) / 2*a";
        String expression3 = "s * (s - a) * (s - b * (s - c)";
        String expression4 = "s * (s - a) * s - b) * (s - c)";
        String expression5 = "(-- b + (b^2 - 4*a*c)^(0.5/ 2*a))";

        System.out.println("Expression 1: " + checkBrackets(expression1));
        System.out.println("Expression 2: " + checkBrackets(expression2));
        System.out.println("Expression 3: " + checkBrackets(expression3));
        System.out.println("Expression 4: " + checkBrackets(expression4));
        System.out.println("Expression 5: " + checkBrackets(expression5));
    }

    public static boolean checkBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
