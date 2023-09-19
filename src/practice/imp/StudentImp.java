package practice.imp;

import practice.entity.Student;

import java.util.Scanner;

public class StudentImp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] studentList = new Student[100];
        int numStudents = 0;

        int choice;
        do {
            System.out.println("====== MENU ======");
            System.out.println("1. Hiển thị danh sách tất cả học sinh");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Sửa thông tin học sinh dựa vào mã học sinh");
            System.out.println("4. Xoá học sinh");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=== Danh sách học sinh ===");
                    displayStudentList(studentList, numStudents);
                    System.out.println("==========================");
                    break;
                case 2:
                    System.out.println("=== Thêm mới học sinh ===");
                    Student newStudent = createStudent(scanner);
                    studentList[numStudents] = newStudent;
                    numStudents++;
                    System.out.println("Thêm học sinh thành công!");
                    break;

                case 3:
                    System.out.println("=== Sửa thông tin học sinh ===");
                    System.out.print("Nhập mã học sinh cần sửa: ");
                    int studentId = scanner.nextInt();
                    int studentIndex = findStudentIndex(studentList, numStudents, studentId);
                    if (studentIndex != -1) {
                        Student studentToUpdate = studentList[studentIndex];
                        updateStudentInfo(scanner, studentToUpdate);
                        System.out.println("Sửa thông tin học sinh thành công!");
                    } else {
                        System.out.println("Không tìm thấy học sinh có mã " + studentId);
                    }
                    break;
                case 4:
                    System.out.println("=== Xoá học sinh ===");
                    System.out.print("Nhập mã học sinh cần xoá: ");
                    int studentIdToDelete = scanner.nextInt();
                    int studentIndexToDelete = findStudentIndex(studentList, numStudents, studentIdToDelete);
                    if (studentIndexToDelete != -1) {
                        removeStudent(studentList, numStudents, studentIndexToDelete);
                        System.out.println("Xoá học sinh thành công!");
                    } else {
                        System.out.println("Không tìm thấy học sinh có mã " + studentIdToDelete);
                    }
                    break;
                case 5:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void displayStudentList(Student[] studentList, int numStudents) {
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Học sinh " + (i + 1));
            studentList[i].displayData();
            System.out.println("--------------------------");
        }
    }

    public static Student createStudent(Scanner scanner) {
        System.out.print("Nhập mã học sinh: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ kí tự '\n'
        System.out.print("Nhập tên học sinh: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi học sinh: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ kí tự '\n'
        System.out.print("Nhập giới tính học sinh: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập địa chỉ học sinh: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại học sinh: ");
        String phone = scanner.nextLine();

        return new Student(id, name, age, gender, address, phone);
    }

    public static void updateStudentInfo(Scanner scanner, Student student) {
        System.out.print("Nhập tên học sinh: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi học sinh: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ kí tự '\n'
        System.out.print("Nhập giới tính học sinh: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập địa chỉ học sinh: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại học sinh: ");
        String phone = scanner.nextLine();

        student.setStudentName(name);
        student.setAge(age);
        student.setGender(gender);
        student.setAddress(address);
        student.setPhoneNumber(phone);
    }

    public static int findStudentIndex(Student[] studentList, int numStudents, int studentId) {
        for (int i = 0; i < numStudents; i++) {
            if (studentList[i].getStudentId() == studentId) {
                return i;
            }
        }
        return -1;
    }

    public static void removeStudent(Student[] studentList, int numStudents, int index) {
        for (int i = index; i < numStudents - 1; i++) {
            studentList[i] = studentList[i + 1];
        }
        studentList[numStudents - 1] = null;
        numStudents--;
    }
}
