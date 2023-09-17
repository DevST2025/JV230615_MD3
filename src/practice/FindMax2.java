package practice;

import java.util.Scanner;

public class FindMax2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng: ");
        int size =  Integer.parseInt(sc.nextLine());

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
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arrInt[i] < arrInt[j]) {
                    int temp = arrInt[i];
                    arrInt[i] = arrInt[j];
                    arrInt[j] = temp;
                }
            }
        }

        int max2 = arrInt[0];
        for (int i = 1; i < size; i++) {
            if (arrInt[i] < max2) {
                max2 = arrInt[i];
                break;
            }
        }
        System.out.printf("Giá trị lớn thứ 2 trong mảng là: %d", max2);
    }
}
