package practice;

import java.util.*;

public class B05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
        Random random = new Random();
        List<Integer> listNumber = new ArrayList<>();
        System.out.print("Bạn có bao nhiêu số trong mảng: ");
        int size = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size; i++) {
            listNumber.add(random.nextInt(100)+1);
        }
        List<Integer> newList = listNumber.stream().sorted().toList();
        System.out.print("Số mà bạn tìm là: ");
        int number = Integer.parseInt(sc.nextLine());
        int result = binarySearch(listNumber, number);

        if (result != -1) {
            System.out.println("Phần tử " + number + " được tìm thấy tại vị trí " + result);
        } else {
            System.out.println("Phần tử " + number + " không được tìm thấy trong mảng.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Lỗi: Nhập không phải là số nguyên.");
    } finally {
        sc.close(); // Bước 5: Đóng Scanner
    }
    }
    public static int binarySearch(List<Integer> list, int number) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == number) {
                return mid;
            } else if (list.get(mid) < number) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
        }


    }

}
