package homework;

import java.util.Scanner;

public class B03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào độ dài mảng: ");
        int length = scanner.nextInt();
        if (length <= 0 || length >= 20) {
            System.out.println("Số lượng phần tử không hợp lệ.");
            return;
        }
        int[] arr = new int[length];

        System.out.println("Nhập các phần tử vào mảng: ");
        for (int i = 0; i < length; i++) {
            System.out.println("Phần tử thứ " + (i + 1) + " :");
            arr[i] = scanner.nextInt();
        }

        int maxValue = arr[0];
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIndex = i + 1;
            }
        }

        System.out.println("Giá trị lớn nhất là: " + maxValue + " tại vị trí thứ " + maxIndex);
    }
}
