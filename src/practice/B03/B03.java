package practice.B03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class B03 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Son"));
        students.add(new Student("Hung"));
        students.add(new Student("Nguyen"));
        students.add(new Student("Chau"));
        List<String> listName = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(listName);
    }
}
