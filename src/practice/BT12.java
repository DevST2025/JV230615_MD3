package practice;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BT12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input size: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("input element # " + (i + 1) + " :");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Input array: ");
        System.out.println("Min value: " + findMinValue(arr));
    }

    public static int findMinValue(int[] arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i :
                arr) {
            queue.offer(i);
        }

        int min = queue.poll();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current < min) {
                min = current;
            }
            queue.offer(current);
        }
        return min;
    }
}
