package homework;

import java.util.Arrays;
import java.util.Scanner;
public class B06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng sinh viên");
        int size = scanner.nextInt();
        if (size <= 0 || size > 30) {
            System.out.println("Mảng ko quả 30 phần tử");
            return;
        }
        double[] scores = new double[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            System.out.println("nhập điểm của sinh viên thứ: " + i + 1);
            scores[i] = scanner.nextDouble();
            if (scores[i] >= 5) {
                count += 1;
            }
        }

        Arrays.toString(scores);
        System.out.printf("Số lượng sinh viên thi đậu là: ", count);
    }
}
