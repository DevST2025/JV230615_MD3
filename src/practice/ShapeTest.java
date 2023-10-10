package practice;

public class ShapeTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Square(3.0);

        for (Shape shape : shapes) {
            System.out.println("Before resizing: " + shape.getArea());
            shape.resize(Math.random() * 100);
            System.out.println("After resizing: " + shape.getArea());
            System.out.println();
        }
    }
}
