package practice;

import java.util.Scanner;

public class FindChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập 1 chuỗi: ");
        String str = sc.nextLine();

        System.out.print("Nhập kí tự bạn muốn tìm trong chuỗi: ");
        char cr = sc.nextLine().charAt(0);

        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == cr) {
                cnt++;
            }
        }

        System.out.printf("Số lần ký tự \"%c\" xuất hiện trong chuỗi \"%s\" là: %d", cr, str, cnt);
    }
}
