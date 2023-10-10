package practice;

import java.util.Scanner;

public class B01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum, lastNum;


        do {
            System.out.print("Nhập vào số thứ 1: ");
            try {
                firstNum = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập lại 1 số nguyên!!!");
            }
        } while (true);
        do {
            System.out.print("Nhập vào số thứ 2: ");
            try {
                lastNum = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập lại 1 số nguyên!!!");
            }
        } while (true);
        int sum = firstNum + lastNum;
        System.out.println("Tổng của 2 số trên là: " + sum);
    }
}
