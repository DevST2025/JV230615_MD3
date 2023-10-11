package practice;

import java.util.HashMap;
import java.util.Scanner;

public class B01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử trong mảng: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < size; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> elementCountMap = new HashMap<>();
        for (int element : array) {
            if (elementCountMap.containsKey(element)) {
                int count = elementCountMap.get(element);
                elementCountMap.put(element, count + 1);
            } else {
                elementCountMap.put(element, 1);
            }
        }
        for (int element : elementCountMap.keySet()) {
            int count = elementCountMap.get(element);
            System.out.println("Phần tử " + element + " xuất hiện " + count + " lần");
        }
    }
}
