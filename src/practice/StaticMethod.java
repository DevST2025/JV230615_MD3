package practice;

public class StaticMethod {
    private static double PI = 3.14;
    public static double calCircleArea(double R) {
        return Math.pow(R, 2) * PI;
    }
    public static double calRectangleArea(double width,double height) {
        return width * height;
    }
    public static double calTriangleArea(double a, double b, double c) {
        double P = (a + b + c) / 2;
        return Math.sqrt(P*(P-1)*(P-2)*(P-3));
    }


}
