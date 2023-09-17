package practice;

import java.util.Scanner;

public class ConvertNumberToWord {
    private static final String[] ones = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên không âm có tối đa 3 chữ số: ");
        int number = scanner.nextInt();

        if (number < 0 || number > 999) {
            System.out.println("Số không hợp lệ!");
        } else {
            String word = convertToWord(number);
            System.out.println("Kết quả: " + word);
        }

        scanner.close();
    }

    public static String convertToWord(int number) {
        if (number == 0) {
            return "zero";
        }

        if (number < 20) {
            return ones[number];
        }

        if (number < 100) {
            return tens[number / 10] + " " + ones[number % 10];
        }

        return ones[number / 100] + " hundred and " + convertToWord(number % 100);
    }
}
