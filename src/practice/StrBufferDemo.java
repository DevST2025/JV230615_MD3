package practice;

import java.util.Scanner;

public class StrBufferDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập 1 chuỗi: ");
        String str = sc.nextLine();
        StringBuffer strBuffer = new StringBuffer(str);

        System.out.printf("Đảo ngược chuỗi %s là: %s", str, strBuffer.reverse());
    }
}
