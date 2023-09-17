package homework;

import java.util.Arrays;
import java.util.Scanner;
public class B05 {
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
        System.out.println(Arrays.toString(arr));
        int index = minValue(arr);
        System.out.println("The min value is: " + arr[index]);
    }

    public static int minValue(int[] arr) {
        int minValue = arr[0];
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
