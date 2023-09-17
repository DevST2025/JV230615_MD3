package practice;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng 1: ");
        int size1 = Integer.parseInt(sc.nextLine());

        int[] arrInt1 = new int[size1];

        for (int i = 0; i < size1; i++) {
            System.out.printf("Nhập số thứ %d: ", i + 1);
            arrInt1[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.print("Mảng 1 là: " + Arrays.toString(arrInt1));
        System.out.println();

        System.out.print("Nhập độ dài mảng 2: ");
        int size2 = Integer.parseInt(sc.nextLine());

        int[] arrInt2 = new int[size2];

        for (int i = 0; i < size2; i++) {
            System.out.printf("Nhập số thứ %d: ", i + 1);
            arrInt2[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.print("Mảng 2 là: " + Arrays.toString(arrInt2));
        System.out.println();

        int[] arrInt3 = new int[size1 + size2];
        for (int i = 0; i < size1; i++) {
            arrInt3[i] = arrInt1[i];
        }
        for (int i = 0; i < size2; i++) {
            arrInt3[i + size1] = arrInt2[i];
        }
        System.out.print("Mảng 3 là: " + Arrays.toString(arrInt3));
        System.out.println();
    }
}
