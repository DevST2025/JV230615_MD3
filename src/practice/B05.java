package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class B05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        List<Integer> listNumber = new ArrayList<>();
        System.out.print("Bạn có bao nhiêu số trong mảng: ");
        int size = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size; i++) {
            listNumber.add(random.nextInt(100)+1);
        }
        List<Integer> newList = listNumber.stream().sorted().toList();
        System.out.println(newList);


    }


}
