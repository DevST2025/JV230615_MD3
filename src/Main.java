import practice.MyClass;
import practice.StaticMethod;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass("Sơn đẹp trai");
        System.out.println(myClass.getMyString());
        myClass.setMyString("Sơn cute");
        System.out.println(myClass.getMyString());

        System.out.println(StaticMethod.calCircleArea(3.5));
        System.out.println(StaticMethod.calCircleArea(6));

        System.out.println(StaticMethod.calTriangleArea(3,4,5));
        System.out.println(StaticMethod.calTriangleArea(4.5,7,6));

        System.out.println(StaticMethod.calRectangleArea(2.5,6));
        System.out.println(StaticMethod.calRectangleArea(4,7));


    }
}
