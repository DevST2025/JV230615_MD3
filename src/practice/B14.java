package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Bước 1: Khai báo biến và nhập dữ liệu
            System.out.print("Nhập số lượng phần tử của mảng: ");
            int n = scanner.nextInt();

            // Bước 2: Kiểm tra điều kiện mảng rỗng
            if (n <= 0) {
                System.out.println("Mảng không có phần tử. Kết thúc chương trình.");
                return;
            }

            int[] arr = new int[n];

            // Bước 3: Nhập giá trị cho mảng
            System.out.println("Nhập các phần tử của mảng:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Bước 4: Tính giá trị trung bình
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }
            double average = (double) sum / n;

            // Bước 5: Hiển thị kết quả
            System.out.println("Giá trị trung bình của mảng là: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Nhập không phải là số nguyên.");
        } finally {
            // Bước 6: Kết thúc chương trình
            scanner.close();
        }
    }
}
