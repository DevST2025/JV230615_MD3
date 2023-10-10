package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B13 {
    public static void main(String[] args) {
        // Bước 1: Khai báo biến và nhập dữ liệu
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần đảo ngược: ");

        try {
            String inputString = scanner.nextLine();

            // Bước 2: Kiểm tra điều kiện chuỗi rỗng hoặc null
            if (inputString == null || inputString.isEmpty()) {
                throw new InputMismatchException("Chuỗi không hợp lệ.");
            }

            // Bước 3: Đảo ngược chuỗi
            String reversedString = reverseString(inputString);

            // Bước 4: Hiển thị kết quả
            System.out.println("Chuỗi đảo ngược: " + reversedString);
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            // Bước 5: Kết thúc chương trình và đóng Scanner
            scanner.close();
        }
    }

    // Phương thức để đảo ngược chuỗi
    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
