package practice;

import java.util.Scanner;

public class ControlStatement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số 1 số nguyên: ");
        int number = sc.nextInt();
        int number1;
        int number2;
        int choise;
        boolean isContinue = true;

        do {
            System.out.println("*****************MENU******************");
            System.out.println("1. Kiểm tra số chẵn/lẻ");
            System.out.println("2. Kiểm tra số nguyên tố");
            System.out.println("3. Kiểm tra số hoàn hảo");
            System.out.println("4. In ra các số chia hết cho 3 và 5 trong khoảng 1-number");
            System.out.println("5. Tính tổng các ước số của number");
            System.out.println("6. Tính tổng các số nguyên tố trong khoảng 1-number");
            System.out.println("7. Nhập 2 số nguyên (number1, number2), kiểm tra number có trong\n" +
                    "khoảng (number1,number2)");
            System.out.println("8. Thoát");
            System.out.print("Vui lòng nhập số trong khoảng 1 - 8 ứng với chức năng bạn muốn: ");
            choise = sc.nextInt();

            switch (choise) {
                case 1:
                    String result = (number % 2 == 0) ? "chẵn" : "lẻ";
                    System.out.println("-----------> " + number + " là số " + result);
                    break;
                case 2:
                    if (number > 1) {
                        if (isPrime(number)) {
                            System.out.printf("-----------> %d là số nguyên tố %n", number);
                        } else {
                            System.out.printf("-----------> %d KHÔNG phải là số nguyên tố %n", number);
                        }
                    } else {
                        System.out.printf("-----------> %d KHÔNG phải là số nguyên tố %n", number);
                    }
                    break;
                case 3:
                    int sum = 0;
                    for (int i = 1; i < number; i++) {
                        if (number % i == 0) {
                            sum += i;
                        }
                    }
                    if (number == sum ) {
                        System.out.printf("-----------> %d là số hoàn hảo %n", number);
                    } else {
                        System.out.printf("-----------> %d KHÔNG phải là số hoàn hảo %n", number);
                    }
                    break;
                case 4:
                    System.out.print("-----------> Các số chia hết cho 3 và 5: ");
                    for (int i = 1; i <= number; i++) {
                        if (i % 3 == 0 && i % 5 == 0) {
                            System.out.printf("%d\t", i);
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    int sum2 = 0;
                    for (int i = 1; i <= number; i++) {
                        if (number % i == 0) {
                            sum2 += i;
                        }
                    }
                    System.out.printf("-----------> tổng các ước số của %d: %d \n", number, sum2);
                    break;
                case 6:
                    int count = 2;
                    int sum3 = 0;
                    while (count <= number) {
                        if (isPrime(count)) {
                            sum3 += count;
                        }
                        count++;
                    }
                    System.out.printf("-----------> tổng các số nguyên tố từ 1 -> %d: %d \n", number, sum3);
                    break;
                case 7:
                    boolean isCheck = false;
                    System.out.print("Nhập số bé: ");
                    number1 = sc.nextInt();
                    System.out.print("Nhập số lớn: ");
                    number2 = sc.nextInt();

                    for (int i = number1; i < number2; i++) {
                        if (number == i) {
                            isCheck = true;
                        }
                    }
                    if (isCheck) {
                        System.out.printf("-----------> %d có nằm trong khoảng %d đến %d \n", number, number1, number2);
                    } else {
                        System.out.printf("-----------> %d KHÔNG có nằm trong khoảng %d đến %d \n", number, number1, number2);
                    }
                    break;
                default:
                    System.out.println("*****************END******************");
                    isContinue = false;
            }
        }
        while (isContinue);
    }
    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
