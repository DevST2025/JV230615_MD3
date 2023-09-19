package practice.imp;

import practice.entity.Circle;

public class CircleImp {
    public static void main(String[] args) {
        Circle circle = new Circle(2.5);

        double radius = circle.getRadius();
        double area = circle.getArea();

        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area);

        circle.setRadius(3.0);

        radius = circle.getRadius();
        area = circle.getArea();

        System.out.println("Updated Radius: " + radius);
        System.out.println("Updated Area: " + area);
    }
}
