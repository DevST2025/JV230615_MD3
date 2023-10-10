package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B06 {
    public static void main(String[] args) {
        // Bước 1: Khai báo biến và nhập dữ liệu
        int dividend, divisor;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số bị chia: ");
        dividend = scanner.nextInt();

        // Bước 2: Xử lý ngoại lệ
        try {
            System.out.println("Nhập số chia: ");
            divisor = scanner.nextInt();

            if (divisor == 0) {
                throw new ArithmeticException("Số chia không thể là 0.");
            }

            // Bước 3: Thực hiện phép chia
            int result = dividend / divisor;

            // Bước 4: Hiển thị kết quả
            System.out.println("Kết quả phép chia: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập một số nguyên.");
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            // Bước 5: Kết thúc chương trình
            scanner.close();
        }
    }
}
