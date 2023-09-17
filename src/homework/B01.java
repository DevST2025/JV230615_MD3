package homework;

import java.util.Scanner;
import java.util.Arrays;

public class B01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int size = scanner.nextInt();
        if (size <= 0 || size > 20) {
            System.out.println("Số lượng phần tử không hợp lệ");
            return;
        }
        int[] arr = new int[size];
        System.out.println("Nhập các phần tử vào mảng: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Phần tử thứ " + (i + 1) + " :");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Mảng trước khi đảo ngược: " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("Mảng sau khi đảo chiều: " + Arrays.toString(arr));
    }

    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
