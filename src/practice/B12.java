package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Bước 1: Nhập dữ liệu
            System.out.print("Nhập số nguyên thứ nhất: ");
            int number1 = scanner.nextInt();

            System.out.print("Nhập số nguyên thứ hai: ");
            int number2 = scanner.nextInt();

            // Bước 2: Kiểm tra điều kiện cả hai số bằng 0
            if (number1 == 0 && number2 == 0) {
                System.out.println("Cả hai số đều bằng 0. Không có ước chung lớn nhất.");
            } else {
                // Bước 3: Tìm ước chung lớn nhất (UCLN)
                int ucln = findUCLN(Math.abs(number1), Math.abs(number2));

                // Bước 4: Hiển thị kết quả
                System.out.println("Ước chung lớn nhất của " + number1 + " và " + number2 + " là: " + ucln);
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn đã nhập không phải là số nguyên.");
        } finally {
            // Bước 5: Kết thúc chương trình
            scanner.close();
        }
    }

    // Hàm để tính ước chung lớn nhất của hai số nguyên
    private static int findUCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
