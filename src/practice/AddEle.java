package practice;

import java.util.Scanner;

public class AddEle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài của mảng: ");
        int length = Integer.parseInt(sc.nextLine());

        int[] arrInt = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Nhập giá trị số thứ %d: ", i + 1);
            arrInt[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("Giá trị thành phần trong mảng lần lượt là: ");
        for (int element : arrInt) {
            System.out.printf("%d\t", element);
        }
        System.out.println();

        do {
            System.out.println("*******MENU*******");
            System.out.println("1. Thêm phần tử vào cuối mảng");
            System.out.println("2. Thêm phần tử vào đầu mảng");
            System.out.println("3. Thêm phần tử vào vị trí nhập từ user vào mảng");
            System.out.println("4. Thoát");
            System.out.print("Nhập số bạn muốn thực hiện: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    System.out.print("Nhập giá trị thêm vào cuối mảng: ");
                    int lastNum = Integer.parseInt(sc.nextLine());
                    //Tạo mảng mới
                    int[] arrNewInt1 = new int[length + 1];
                    for (int i = 0; i < length; i++) {
                        arrNewInt1[i] = arrInt[i];
                    }
                    arrNewInt1[length] = lastNum;
                    System.out.println("Giá trị thành phần trong mảng mới lần lượt là: ");
                    for (int element : arrNewInt1) {
                        System.out.printf("%d\t", element);
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Nhập giá trị thêm vào đầu mảng: ");
                    int firstNum = Integer.parseInt(sc.nextLine());
                    //Tạo mảng mới
                    int[] arrNewInt2 = new int[length + 1];
                    for (int i = 0; i < length; i++) {
                        arrNewInt2[i + 1] = arrInt[i];
                    }
                    arrNewInt2[0] = firstNum;
                    System.out.println("Giá trị thành phần trong mảng mới lần lượt là: ");
                    for (int element : arrNewInt2) {
                        System.out.printf("%d\t", element);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Nhập giá trị muốn thêm vào mảng: ");
                    int number = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập chỉ số muốn thêm giá trị vào mảng: ");
                    int index = Integer.parseInt(sc.nextLine());
                    //Tạo mảng mới
                    int[] arrNewInt3 = new int[length + 1];

                    //check xem chỉ mục có nằm trong độ dài của mảng không
                    if (index < 0 || index > length ) {
                        System.out.println("vui nhập chỉ số nằm trong độ dài của mảng: ");
                        break;
                    } else {
                        for (int i = 0; i < index + 1; i++) {
                            arrNewInt3[i] = arrInt[i];
                        }
                        arrNewInt3[index] = number;
                        for (int i = index; i < length; i++) {
                            arrNewInt3[i + 1] = arrInt[i];
                        }
                        System.out.println("Giá trị thành phần trong mảng mới lần lượt là: ");
                        for (int element : arrNewInt3) {
                            System.out.printf("%d\t", element);
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("*******MENU*******");
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập 1 số từ 1 -> 4");
            }
        }
        while (true);
    }
}
