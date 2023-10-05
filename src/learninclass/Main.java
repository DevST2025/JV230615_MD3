package learninclass;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> arr = Stream.generate(()-> random.nextInt(100000)).distinct().limit(100000).collect(Collectors.toList());
        LocalDateTime l1 = LocalDateTime.now();
        int index = findIndex(10, arr);
        LocalDateTime l2 = LocalDateTime.now();
        long time = ChronoUnit.MICROS.between(l1, l2);
        System.out.println(time);

    }
    public static int findIndex(Integer value, List<Integer> list) {
        //thuật toán tìm kiếm tuyến tính
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), value)) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == arr[mid]) {
                return mid;
            }
            if (value > arr[mid]) {
                low = mid + 1;
            }
            if (value < arr[mid]) {
                high = mid -1;
            }
        }
        return -1;
    }

    public static int binarySearchDQ(int[] arr, int low, int high, int value) {

        low = 0;
        high = arr.length - 1;
        if (low <= high) {
            int mid = (low + high) / 2;
            if (value == arr[mid]) {
                return mid;
            }
            if (value > arr[mid]) {
                return binarySearchDQ(arr, mid + 1, high, value);
            }
            if (value < arr[mid]) {
                return binarySearchDQ(arr, low, mid - 1, value);
            }
        }
        return -1;
    }
}
