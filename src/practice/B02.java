package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> listNumber = new ArrayList<>();
        System.out.print("Bạn muốn nhập bao nhiêu số vào mảng: ");
        int size = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size; i++) {
            System.out.printf("Thêm số thứ %d : \n", i + 1);
            listNumber.add(Integer.parseInt(sc.nextLine()));
        }
        if (listNumber.isEmpty()) {
            throw new RuntimeException("Mảng rỗng không được giá trị lớn nhất");
        }
        System.out.println(listNumber);
        int maxValue = 0;
        for (int i = 0; i < listNumber.size(); i++) {
            if (maxValue < listNumber.get(i)) {
                maxValue = listNumber.get(i);
            }
        }

        System.out.println("Số lớn nhất tìm được là: " + maxValue);
    }
}
