package homework;

import java.util.Scanner;

public class B04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double celsius, fahrenheit;

        while (true) {
            System.out.println("***************** MENU ******************");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nhập độ Fahrenheit: ");
                    fahrenheit = scanner.nextDouble();
                    double convertedCelsius = fahrenheitToCelsius(fahrenheit);
                    System.out.printf("Độ Celsius tương ứng: %.2f" + convertedCelsius);
                    break;
                case 2:
                    System.out.println("Nhập độ Celsius: ");
                    celsius = scanner.nextDouble();
                    double convertedFahrenheit = celsiusToFahrenheit(celsius);
                    System.out.println("Độ Fahrenheit tương ứng: " + convertedFahrenheit);
                    break;
                case 0:
                    System.out.println("Kết thúc!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Yêu cầu nhập lại.");
            }
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}
