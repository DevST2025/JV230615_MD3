package push;

import java.util.Scanner;

public class B01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài của mảng: ");
        int size = Integer.parseInt(sc.nextLine());

        int[] arrInt = new int[size];

        do {
            System.out.println("**********MENU**********");
            System.out.println("1. Nhập giá trị các phần tử mảng");
            System.out.println("2. Hiển thị giá trị các phần tử mảng");
            System.out.println("3. In các phần tử giá trị chẵn trong mảng và tính tổng");
            System.out.println("4. In các phần tử có giá trị là số nguyên tố và tính tổng");
            System.out.println("5. In ra phần tử có giá trị lớn nhất và nhỏ nhất trong mảng");
            System.out.println("6. Sắp xếp mảng giảm dần");
            System.out.println("7. Nhập vào giá trị số nguyên (m) và thống kê trong mảng có bao\n" +
                    "nhiêu phần tử có giá trị là m");
            System.out.println("8. Thoát");
            System.out.print("Nhập số mà bạn muốn thực hiện: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    for (int i = 0; i < size; i++) {
                        System.out.printf("Nhập giá trị thứ %d: ", i + 1);
                        arrInt[i] = Integer.parseInt(sc.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Biểu diễn mảng là: ");
                    for (int element : arrInt) {
                        System.out.printf("%d\t", element);
                    }
                    System.out.printf("\n");
                    break;
                case 3:
                    int sum = 0;
                    System.out.println("Các giá trị chãn có trong mảng là: ");
                    for (int i = 0; i < size; i++) {
                        if (arrInt[i] % 2 == 0) {
                            System.out.printf("%d\t", arrInt[i]);
                            sum += arrInt[i];
                        }
                    }
                    System.out.printf(" - Tổng là %d", sum);
                    System.out.printf("\n");
                    break;
                case 4:
                    int sum2 = 0;
                    System.out.println("Các giá trị là số nguyên có trong mảng là: ");
                    for (int i = 0; i < size; i++) {
                        if (arrInt[i] > 1) {
                            if (isPrime(arrInt[i])) {
                                System.out.printf("%d\t", arrInt[i]);
                                sum2 += arrInt[i];
                            }
                        }
                    }
                    System.out.printf(" - Tổng là %d", sum2);
                    System.out.printf("\n");
                    break;
                case 5:
                    System.out.printf("Giá trị lớn nhất là %d và nhỏ nhất là %d\n", maxInt(arrInt), minInt(arrInt));
                    break;
                case 6:
                    sortDown(arrInt);
                    System.out.println("Biểu diễn mảng là: ");
                    for (int element : arrInt) {
                        System.out.printf("%d\t", element);
                    }
                    System.out.printf("\n");
                    break;
                case 7:
                    System.out.print("Nhập số mà bạn muốn tìm trong mảng: ");
                    int number = Integer.parseInt(sc.nextLine());

                    int count = 0;
                    boolean isCheck = true;
                    for (int i = 0; i < size; i++) {
                        if (arrInt[i] == number) {
                            count++;
                            isCheck = false;
                        }
                    }

                    if (isCheck) {
                        System.out.printf("Không có %d trong mảng", number);
                    } else {
                        System.out.printf("Có %d xuất hiện %d lần trong mảng", number, count);
                    }
                    System.out.printf("\n");
                    break;
                case 8:
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

    public static int maxInt(int[] arrInt) {
        int max = 0;
        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] > max) {
                max = arrInt[i];
            }
        }
        return max;
    }

    public static int minInt(int[] arrInt) {
        int min = arrInt[0];
        for (int i = 1; i < arrInt.length; i++) {
            if (arrInt[i] < min) {
                min = arrInt[i];
            }
        }
        return min;
    }

    public static void sortDown(int[] arrInt) {
        for (int i = 0; i < arrInt.length - 1; i++) {
            for (int j = i + 1; j < arrInt.length; j++) {
                if (arrInt[i] < arrInt[j]) {
                    int temp = arrInt[i];
                    arrInt[i] = arrInt[j];
                    arrInt[j] = temp;
                }
            }
        }
    }
}
