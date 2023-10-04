package practice;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class B06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào năm sinh để tính tuổi: ");
        Year inputYear = Year.parse(sc.nextLine());

        long age = ChronoUnit.YEARS.between(inputYear, LocalDate.now());
        System.out.println(age);
    }
}
