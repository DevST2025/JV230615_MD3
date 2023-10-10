package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double side1, side2, side3;

        try {
            System.out.print("Nhập cạnh thứ nhất: ");
            side1 = scanner.nextDouble();
            System.out.print("Nhập cạnh thứ hai: ");
            side2 = scanner.nextDouble();
            System.out.print("Nhập cạnh thứ ba: ");
            side3 = scanner.nextDouble();

            if (side1 <= 0 || side2 <= 0 || side3 <= 0 || (side1 + side2 <= side3) || (side1 + side3 <= side2) || (side2 + side3 <= side1)) {
                throw new IllegalTriangleException("Các cạnh không thể tạo thành một tam giác.");
            }

            System.out.println("Ba cạnh đã nhập hợp lệ và tạo thành một tam giác.");
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập một số thực.");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

}
class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
}
