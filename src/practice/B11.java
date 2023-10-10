package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Bước 1: Nhập ngày, tháng và năm từ người dùng
            System.out.print("Nhập ngày (số nguyên): ");
            int day = scanner.nextInt();
            System.out.print("Nhập tháng (số nguyên): ");
            int month = scanner.nextInt();
            System.out.print("Nhập năm (số nguyên): ");
            int year = scanner.nextInt();

            // Bước 2: Kiểm tra tính hợp lệ của ngày tháng năm
            if (isValidDate(day, month, year)) {
                System.out.println("Ngày tháng năm hợp lệ.");
            } else {
                throw new InputMismatchException("Ngày tháng năm không hợp lệ.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Phương thức kiểm tra tính hợp lệ của ngày tháng năm
    public static boolean isValidDate(int day, int month, int year) {
        if (year <= 0) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > daysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    // Phương thức tính số ngày trong một tháng
    public static int daysInMonth(int month, int year) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month];
    }

    // Phương thức kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
