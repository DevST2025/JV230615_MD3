package practice;

import java.util.Scanner;

public class Equals {
    public static void main(String[] args) {
        String str1 = "tranhongson";
        System.out.println("Chuỗi mẫu: " + str1);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập 1 chuỗi: ");
        String str = sc.nextLine();

        if (str1.equals(str)) {
            System.out.printf("Chuỗi %s trùng với chuỗi mẫu!!!", str);
        } else {
            System.out.printf("Chuỗi %s KHÔNG trùng với chuỗi mẫu!!!", str);
        }
    }
}
