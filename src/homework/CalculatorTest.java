package homework;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator calculator =  new Calculator();
        System.out.print("Enter number A: ");
        double numberA = sc.nextInt();
        System.out.print("Enter number B: ");
        double numberB = sc.nextInt();

        calculator.setNumberA(numberA);
        calculator.setNumberB(numberB);

        System.out.println("Sum of two numbers: " + calculator.add());
        System.out.println("Subtraction of two numbers: " + calculator.sub());
        System.out.println("Multiple of two numbers: " + calculator.multi());

        if(numberB > 0) {
            System.out.println("Divide of two numbers: " + calculator.div());
        } else {
            System.out.println("NumberA or NumberB must be different 0!");
        }

    }
}
