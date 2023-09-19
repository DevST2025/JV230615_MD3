package practice.entity;

public class StaticMethod {
    public static final double PI = 3.14;

    public static double calCircleArea(double radius) {
        return PI * radius * radius;
    }

    public static double calRectangleArea(double width, double height) {
        return width * height;
    }

    public static double calTriangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        double circleRadius1 = 3.5;
        double circleRadius2 = 6.0;

        double circleArea1 = StaticMethod.calCircleArea(circleRadius1);
        double circleArea2 = StaticMethod.calCircleArea(circleRadius2);

        System.out.println("Diện tích hình tròn 1: " + circleArea1);
        System.out.println("Diện tích hình tròn 2: " + circleArea2);

        double triangleSide1 = 3;
        double triangleSide2 = 4;
        double triangleSide3 = 5;

        double triangleArea = StaticMethod.calTriangleArea(triangleSide1, triangleSide2, triangleSide3);

        System.out.println("Diện tích tam giác: " + triangleArea);

        double rectangleWidth = 2.5;
        double rectangleHeight = 6.0;

        double rectangleArea = StaticMethod.calRectangleArea(rectangleWidth, rectangleHeight);

        System.out.println("Diện tích hình chữ nhật: " + rectangleArea);
    }
}
