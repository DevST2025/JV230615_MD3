package practice;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class B07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi ngày tháng có định dạng dd-MM: ");
        String inputDate = sc.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM");
        MonthDay date = MonthDay.parse(inputDate, dateTimeFormatter);
        System.out.println(dateTimeFormatter.format(date));
    }
}
