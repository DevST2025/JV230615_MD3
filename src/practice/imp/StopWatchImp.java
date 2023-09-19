package practice.imp;

import practice.entity.StopWatch;

public class StopWatchImp {
    public static void main(String[] args) {
        // Tạo đối tượng StopWatch
        StopWatch stopWatch = new StopWatch();

        // Tạo mảng ngẫu nhiên
        int[] arr = generateRandomArray(100000);

        // Sắp xếp mảng bằng thuật toán selection sort
        selectionSort(arr);

        // Dừng đồng hồ
        stopWatch.stop();

        // In ra thời gian thực thi
        System.out.println("Elapsed Time: " + stopWatch.getElapsedTime() + " milliseconds");
    }

    // Phương thức sinh mảng ngẫu nhiên
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    // Phương thức sắp xếp mảng bằng selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
