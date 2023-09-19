package practice.entity;

import java.util.Scanner;

public class Circle {
    double radisus;
    public Circle() {

    }
    public Circle(double radisus) {
        this.radisus = radisus;
    }

    public double getRadisus() {
        return radisus;
    }

    public void setRadisus(double radisus) {
        this.radisus = radisus;
    }
    public double perimeter() {
        return this.radisus * 2 * Math.PI;
    }
    public double area() {
        return Math.pow(this.radisus, 2) * Math.PI;
    }
    public void inputData(Scanner sc) {
        System.out.print("Nhập bán kính hình tròn: ");
        boolean isExist = true;
        do {
            this.radisus = Double.parseDouble(sc.nextLine());
            if (this.radisus > 0) {
                break;
            } else {
                System.err.println("Vui lòng nhập bán kính lớn hơn 0!!!");
            }
        }
        while (isExist);
    }
    public void displayData() {
        System.out.printf("Bán kính: %.2f- Chi vi: %.2f- Diện tích: %.2f", this.radisus, perimeter(), area());
    }
}

