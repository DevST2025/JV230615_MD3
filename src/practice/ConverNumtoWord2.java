package practice;

import java.util.Scanner;

public class ConverNumtoWord2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số cần chuyển đổi (0-9): ");
        int number = scanner.nextInt();
        String result;

        switch (number) {
            case 0:
                result = "Zero";
                break;
            case 1:
                result = "One";
                break;
            case 2:
                result = "Two";
                break;
            case 3:
                result = "Three";
                break;
            case 4:
                result = "Four";
                break;
            case 5:
                result = "Five";
                break;
            case 6:
                result = "Six";
                break;
            case 7:
                result = "Seven";
                break;
            case 8:
                result = "Eight";
                break;
            case 9:
                result = "Nine";
                break;
            default:
                result = "Số không hợp lệ";
                break;
        }

        System.out.println(result);

        scanner.close();
    }
}
