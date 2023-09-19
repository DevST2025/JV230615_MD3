package practice.imp;

import practice.entity.Student;

public class StudentImp {
    public static void main(String[] args) {
        Student student = new Student();

        System.out.println("Initial Name: " + student.getName());
        System.out.println("Initial Class: " + student.getClasses());

        student.setName("Alice");
        student.setClasses("C03");

        System.out.println("Updated Name: " + student.getName());
        System.out.println("Updated Class: " + student.getClasses());
    }
}
