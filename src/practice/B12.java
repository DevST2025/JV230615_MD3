package practice;

import java.util.*;
import java.util.stream.Collectors;

public class B12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập giá trị muốn so sánh: ");
        int number = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập vào số lượng số cần biểu thị: ");
        int size = Integer.parseInt(sc.nextLine());
//        List<Integer> list = Arrays.asList(234,123,543,213,645,343);
//        List<Integer> result = findMaxThanInput(list, number, size, Comparator.comparingInt(a -> a));
//        System.out.println(result);

        Comparator<Student> comparator = Comparator.comparingInt(Student::getAge);

        List<Student> listStudent = new ArrayList<>();
        Student s1 = new Student(1, "Son");
        Student s2 = new Student(3, "Son");
        Student s3 = new Student(6, "Son");
        Student s4 = new Student(8, "Son");

        listStudent.add(new Student(2, "Nguyen"));
        listStudent.add(new Student(4, "Nguyen"));
        listStudent.add(new Student(6, "Huyen"));
        listStudent.add(new Student(8, "Hung"));
        List<Student> result1 = findMaxThanInput(listStudent, new Student(number, "Nguyen"), size, comparator);
        System.out.println(result1);


    }
    public static <T> List<T> findMaxThanInput(List<T> list, T t, int size, Comparator<T> comparator) {
        return list.stream().filter(o->comparator.compare(o, t)>0).sorted(comparator.reversed()).limit(size).toList();
    }

}
