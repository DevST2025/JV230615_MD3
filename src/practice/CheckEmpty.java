package practice;

import java.util.Scanner;

public class CheckEmpty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập 1 chuỗi: ");
        String str = sc.nextLine();

        if (str.isEmpty()) {
            System.out.println("Chuỗi này không phải là chuỗi rỗng");
        } else {
            System.out.println("Chuỗi này không phải là chuỗi rỗng");
        }
    }
}
