package practice;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USD: ");
        double USD = Double.parseDouble(sc.nextLine());
        double VND = converUSDtoVND(USD);
        System.out.printf("%.2f VND ", VND);
    }
    public static double converUSDtoVND(double money) {
        return money * 23000;
    }
}
