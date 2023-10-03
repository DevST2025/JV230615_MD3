package practice;

import java.util.Stack;

public class BT10 {
    public static void main(String[] args) {
        String expression = "5 2 + 3 *";

        int result = calculateExpression(expression);
        System.out.println("Kết quả: " + result);
    }

    public static int calculateExpression(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] elements = expression.split(" ");
        for (String element : elements) {
            if (isNumeric(element)) {
                stack.push(Integer.parseInt(element));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (element) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
