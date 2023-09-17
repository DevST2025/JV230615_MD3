package homework;

import java.util.Date;
import java.util.Scanner;

public class UseOperator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width: ");
        double width = Double.parseDouble(sc.nextLine());
        System.out.print("Enter height: ");
        double height = Double.parseDouble(sc.nextLine());

        double area = width * height;
        System.out.printf("Area is : %.2f", area);
    }
}
