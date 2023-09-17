package practice;

import java.util.Scanner;

public class RemoveEle {
    public static void main(String[] args) {
        //Cách mẹo
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập độ dài của mảng: ");
//        int length = Integer.parseInt(sc.nextLine());
//
//        int[] arrInt = new int[length];
//
//        for (int i = 0; i < length; i++) {
//            System.out.printf("Nhập giá trị số thứ %d: ", i + 1);
//            arrInt[i] = Integer.parseInt(sc.nextLine());
//        }
//
//        System.out.println("Giá trị thành phần trong mảng lần lượt là: ");
//        for (int element : arrInt) {
//            System.out.printf("%d\t", element);
//        }
//        System.out.println();
//
//        System.out.print("Nhập số mà bạn cần xoá: ");
//        int intDel = Integer.parseInt(sc.nextLine());
//        int indexDel = 0;
//        for (int i = 0; i < length; i++) {
//            if (arrInt[i] == intDel ) {
//                System.out.print("Vị trí index của số cần xoá là: ");
//                indexDel = i;
//                System.out.println(i);
//            } else {
//                System.out.printf("Không tìm thấy số %d trong mảng\n", intDel);
//                System.exit(0);
//            }
//        }
//
//        for (int i = indexDel; i < length - 1; i++) {
//            arrInt[i] = arrInt[i + 1];
//        }
//        arrInt[length - 1] = 0;
//        System.out.println("Giá trị thành phần trong mảng thay đổi lần lượt là: ");
//        for (int element : arrInt) {
//            System.out.printf("%d\t", element);
//        }

        //Cách đúng
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

        System.out.print("Nhập số mà bạn cần xoá: ");
        int intDel = Integer.parseInt(sc.nextLine());

        //Tìm số lượng số cần xoá có trong mảng
        int cntDel = 0;
        for (int i = 0; i < length; i++) {
            if (intDel == arrInt[i]) {
                cntDel++;
            }
        }
        int index = 0;

        //Tạo mảng mới
        int[] arrNewInt = new int[length - cntDel];

        //Add giá trị khác giá trị trùng vào mảng mới
        for (int i = 0; i < length; i++) {
            if (arrInt[i] != intDel) {
                arrNewInt[index] = arrInt[i];
                index++;
            }
        }
        System.out.println("Giá trị thành phần trong mảng mới lần lượt là: ");
        for (int element : arrNewInt) {
            System.out.printf("%d\t", element);
        }
        System.out.println();
    }
}
