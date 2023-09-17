package practice;

import java.util.Scanner;

public class SumInCol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài hàng: ");
        int row = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập độ dài cột: ");
        int col = Integer.parseInt(sc.nextLine());

        int[][] arrInt = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập giá trị cho hàng %d, cột %d: ", i + 1, j + 1);
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

        System.out.print("Nhập số cột muốn tính tổng: ");
        int pickCol = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += arrInt[i][pickCol - 1];
        }

        System.out.printf("Tổng của cột %d là: %d", (pickCol), sum);
    }
}
