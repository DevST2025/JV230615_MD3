package practice;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BT15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number: ");
        int number = scanner.nextInt();
        System.out.println("To binary number: " + convertToDecimalToBinary(number));
    }

    public static String convertToDecimalToBinary(int number) {
        StringBuilder binaryString = new StringBuilder();
        while (number > 0) {
            int remainder = number % 2;
            binaryString.insert(0, remainder);
            number /= 2;
        }
        return binaryString.toString();
    }

}
