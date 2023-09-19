package practice.entity;

import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c;
    double delta, root1, root2;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void getDiscriminant() {
        delta = this.b * 2 - 4*this.a*this.c;

        if(delta >= 0) {
            System.out.printf("The equation has two roots %f and %f" , getRoot1(), getRoot2());
        }else if(delta == 0) {
            System.out.printf("The equation has one root %f", getRoot1());
        }else {
            System.out.println("The equation has no roots");
        }

    }

    public double getRoot1() {
        return root1 = (-b + Math.pow(b*b-4*a*c, 0.5) / 2*a);
    }

    public double getRoot2() {
        return root2 = (-b - Math.pow(b*b-4*a*c, 0.5) / 2*a);
    }

    public void inputData(Scanner scanner) {
        System.out.println("Enter a:");
        this.a = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter b:");
        this.b = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter a:");
        this.b = scanner.nextDouble();
    }
}
