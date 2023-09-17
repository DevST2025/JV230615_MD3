package practice;

import java.util.Arrays;
import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài hàng: ");
        int row = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập độ dài cột: ");
        int col = Integer.parseInt(sc.nextLine());

        int[][] arrInt = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập giá trị cho hàng %d, cột %d: ", i, j);
                arrInt[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        System.out.println("Biểu diễn mảng là: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%d\t", arrInt[i][j]);
            }
            System.out.println();
        }

        System.out.println("Giá trị lớn nhất trong mảng là: ");
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arrInt[i][j] > max) {
                    max = arrInt[i][j];
                }
            }
        }
        System.out.println("Gía trị lớn nhất của mảng là: " + max);
    }
}
