package practice.entity;

import java.util.Scanner;

public class Student {
    private int studentId;
    private String studentName;
    private int age;
    private String gender;
    private String address;
    private String phoneNumber;

    public Student() {
        // constructor không tham số
    }

    public Student(int id, String name, int age, String gender, String address, String phone) {
        studentId = id;
        studentName = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        phoneNumber = phone;
    }


    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã học sinh: ");
        studentId = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ kí tự '\n'

        System.out.print("Nhập tên học sinh: ");
        studentName = scanner.nextLine();

        System.out.print("Nhập tuổi học sinh: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ kí tự '\n'

        System.out.print("Nhập giới tính học sinh: ");
        gender = scanner.nextLine();

        System.out.print("Nhập địa chỉ học sinh: ");
        address = scanner.nextLine();

        System.out.print("Nhập số điện thoại học sinh: ");
        phoneNumber = scanner.nextLine();

        scanner.close();
    }

    public void displayData() {
        System.out.println("Mã HS: " + studentId);
        System.out.println("Tên HS: " + studentName);
        System.out.println("Tuổi: " + age);
        System.out.println("Giới tính: " + gender);
        System.out.println("Địa chỉ: " + address);
        System.out.println("Số điện thoại: " + phoneNumber);
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int id) {
        studentId = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        studentName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        phoneNumber = phone;
    }
}
