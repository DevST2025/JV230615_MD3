package push;

import java.util.Scanner;

public class B02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài hàng: ");
        int row = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập độ dài cột: ");
        int col = Integer.parseInt(sc.nextLine());

        int[][] arrInt = new int[row][col];

        do {
            System.out.println("**********MENU**********");
            System.out.println("1. Nhập giá trị các phần tử mảng 2 chiều");
            System.out.println("2. In giá trị các phần tử theo ma trận");
            System.out.println("3. In giá trị các phần tử nằm trên đường biên của ma trận và tính tổng");
            System.out.println("4. In giá trị các phần tử nằm trên đường chéo chính và chéo phụ và\n" +
                    "tính tổng");
            System.out.println("5. In ra giá trị lớn nhất và nhỏ nhất trong mảng");
            System.out.println("6. Sắp xếp mảng tăng dần theo cột");
            System.out.println("7. Thoát");
            System.out.print("Nhập số mà bạn muốn thực hiện : ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.printf("Nhập giá trị hàng %d cột %d: ", i + 1, j + 1);
                            arrInt[i][j] = Integer.parseInt(sc.nextLine());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Biểu diễn mảng là: ");
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.printf("%d\t", arrInt[i][j]);
                        }
                        System.out.printf("\n");
                    }
                    System.out.printf("\n");
                    break;
                case 3:
                    int sum = 0;
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if (i == 0) {
                                System.out.printf("%d\t", arrInt[i][j]);
                                sum += arrInt[i][j];
                            }
                            if ((j == 0 || j == col - 1) && (i > 0 && i < row - 1)) {
                                System.out.printf("%d\t", arrInt[i][j]);
                                sum += arrInt[i][j];
                            }
                            if (i == row - 1) {
                                System.out.printf("%d\t", arrInt[i][j]);
                                sum += arrInt[i][j];
                            }
                        }
                    }
                    System.out.printf(" - Tổng là %d", sum);
                    System.out.printf("\n");
                    break;
                case 4:
                    if (row != col) {
                        System.err.println("Vui lòng nhập ma trận vuông (hàng và cột bằng nhau)");
                        System.exit(0);
                    }
                    sum = 0;
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if (i == j) {
                                System.out.printf("%d\t", arrInt[i][j]);
                                sum += arrInt[i][j];
                            }
                        }
                    }
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if ((i + j) == (row - 1)) {
                                System.out.printf("%d\t", arrInt[i][j]);
                                sum += arrInt[i][j];
                            }
                        }
                    }
                    System.out.printf(" - Tổng là %d", sum);
                    System.out.printf("\n");
                    break;
                case 5:
                    System.out.printf("Giá trị lớn nhất là %d và nhỏ nhất là %d\n", maxInt(arrInt), minInt(arrInt));
                    break;
                case 6:
                    sortUpInCol(arrInt);
                    System.out.println(" Sắp xếp mảng tăng dần theo cột: ");
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.printf("%d\t", arrInt[i][j]);
                        }
                        System.out.printf("\n");
                    }
                    System.out.printf("\n");
                    break;
                case 7:
                    System.out.println("**********END**********");
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập số trong khoảng 1 -> 8");
            }
        }
        while (true);
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int maxInt(int[][] arrInt) {
        int max = 0;
        for (int i = 0; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt[0].length; j++) {
                if (arrInt[i][j] > max) {
                    max = arrInt[i][j];
                }
            }
        }
        return max;
    }

    public static int minInt(int[][] arrInt) {
        int min = arrInt[0][0];
        for (int i = 1; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt[0].length; j++) {
                if (arrInt[i][j] < min) {
                    min = arrInt[i][j];
                }
            }
        }
        return min;
    }

    public static void sortUpInCol(int[][] arrInt) {
        for (int column = 0; column < arrInt[0].length; column++) {
            for (int i = 0; i < arrInt.length - 1; i++) {
                for (int j = i + 1; j < arrInt.length; j++) {
                    if (arrInt[i][column] > arrInt[j][column]) {
                        int temp = arrInt[i][column];
                        arrInt[i][column] = arrInt[j][column];
                        arrInt[j][column] = temp;
                    }
                }
            }
        }
    }
}
