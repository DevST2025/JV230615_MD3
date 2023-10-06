package learninclass;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("son", 18);
        students[1] = new Student("hung", 19);
        students[2] = new Student("nguyen", 12);
        students[3] = new Student("chau", 24);
        students[4] = new Student("bo", 40);

        insertionSort(students);
        System.out.println(Arrays.toString(students));
    }
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        boolean isChecked = true;
        for (int i = 1; i < arr.length && isChecked; i++) {
            isChecked = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isChecked = true;
                }
            }
        }
    }


    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            T min = arr[i];
            int curIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min.compareTo(arr[j]) < 0) {
                    min = arr[j];
                    curIndex = j;
                }
            }
            if (curIndex != i) {
                arr[curIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T curValue = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j].compareTo(curValue) > 0; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = curValue;
        }
    }
}
