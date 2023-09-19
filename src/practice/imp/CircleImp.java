package practice.imp;

import practice.entity.Circle;

import java.util.Scanner;

public class CircleImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle circle = new Circle();
        System.out.println("Nhập thông tin hình tròn: ");
        circle.inputData(sc);
        circle.displayData();
        sc.close();
    }
}
