package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double banKinh = 0;
        double dienTich = 0;
        boolean nhapLai = true;

        while (nhapLai) {
            try {
                System.out.print("Nhập bán kính hình tròn: ");
                banKinh = scanner.nextDouble();

                if (banKinh < 0) {
                    System.out.println("Bán kính không thể là một số âm. Vui lòng nhập lại.");
                } else {
                    nhapLai = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Bạn phải nhập một số. Vui lòng nhập lại.");
                scanner.next(); // Đọc bỏ dòng chứa giá trị không hợp lệ
            }
        }

        dienTich = Math.PI * Math.pow(banKinh, 2);
        System.out.println("Diện tích hình tròn là: " + dienTich);

        scanner.close();
    }
}
