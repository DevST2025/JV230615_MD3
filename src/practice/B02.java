package practice;

import java.util.HashMap;
import java.util.Scanner;

public class B02 {
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
        HashMap<Integer, Integer> uniqueElementsMap = new HashMap<>();

        for (int element : array) {
            if (uniqueElementsMap.containsKey(element)) {
                int count = uniqueElementsMap.get(element);
                uniqueElementsMap.put(element, count + 1);
            } else {
                uniqueElementsMap.put(element, 1);
            }
        }
        int[] uniqueElements = new int[uniqueElementsMap.size()];
        int index = 0;
        for (int element : uniqueElementsMap.keySet()) {
            if (uniqueElementsMap.get(element) == 1) {
                uniqueElements[index] = element;
                index++;
            }
        }
        System.out.println("Các phần tử duy nhất trong mảng:");
        for (int element : uniqueElements) {
            System.out.print(element + " ");
        }
    }
}
