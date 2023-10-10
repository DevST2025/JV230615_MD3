package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B07 {
    public static void main(String[] args) {
        // Bước 1: Khai báo biến
        int num1, num2;

        // Bước 2: Nhập dữ liệu và xử lý ngoại lệ
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            try {
                System.out.print("Nhập số nguyên thứ nhất: ");
                num1 = scanner.nextInt();
                System.out.print("Nhập số nguyên thứ hai: ");
                num2 = scanner.nextInt();
                validInput = true;

                // Bước 4: So sánh và tìm số lớn nhất
                int max = Math.max(num1, num2);
                System.out.println("Số lớn nhất là: " + max);
            } catch (InputMismatchException e) {
                // Xử lý ngoại lệ InputMismatchException
                System.out.println("Lỗi: Bạn cần nhập số nguyên. Vui lòng nhập lại.");
                scanner.nextLine(); // Đọc và loại bỏ dữ liệu không hợp lệ trong buffer
            }
        } while (!validInput);

        // Đóng scanner
        scanner.close();
    }
}
