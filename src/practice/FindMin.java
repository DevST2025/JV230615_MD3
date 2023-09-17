package practice;

import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng: ");
        int size = Integer.parseInt(sc.nextLine());

        int[] arrInt = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("Nhập giá trị thứ %d: ", i + 1);
            arrInt[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Biểu diễn mảng là: ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d\t", arrInt[i]);
        }

        System.out.println();
        int min = arrInt[0];
        for (int i = 1; i < size; i++) {
            if (arrInt[i] < min) {
                min = arrInt[i];
            }
        }
        System.out.println("Giá trị nhỏ nhất của mảng là: " + min);
    }
}
