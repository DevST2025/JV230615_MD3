package practice.entity;

public class MyClass {
    private String myString;

    public MyClass() {
    }

    public MyClass(String myString) {
        this.myString = myString;
    }

    public static void main(String[] args) {
        MyClass myObject = new MyClass();

        System.out.println("Giá trị ban đầu của myString: " + myObject.getMyString());

        myObject.setMyString("Hello, world!");

        System.out.println("Giá trị mới của myString: " + myObject.getMyString());
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }
}
