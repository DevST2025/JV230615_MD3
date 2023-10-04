package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class B08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào thời điểm thứ nhất: ");
        String inputFirstDate = sc.nextLine();
        System.out.print("Nhập vào thời điểm thứ hai: ");
        String inputSecondDate = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate firstDate = LocalDate.parse(inputFirstDate, formatter);
        LocalDate secondDate = LocalDate.parse(inputSecondDate, formatter);
        long days = ChronoUnit.DAYS.between(firstDate, secondDate);
        System.out.println("Khoảng cách giữa 2 ngày là: " + Math.abs(days));
    }
}
