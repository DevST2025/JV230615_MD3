package plus.imp;

import plus.entity.Student;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] arrStudent = new Student[100];
        int currentIndex = 0;

        do {
            System.out.println("**********************MENU*********************");
            System.out.println("1. Nhập vào thông tin n sinh viên (n nhập từ bàn phím)");
            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
            System.out.println("3. Hiển thị thông tin tất cả sinh viên");
            System.out.println("4. Sắp xếp sinh viên theo điểm trung bình giảm dần");
            System.out.println("5. Tìm kiếm sinh viên theo tên sinh viên (Tên sinh viên cần tìm nhập từ bàn phím)");
            System.out.println("6. Thoát");
            System.out.print("Chọn số mà bạn muốn thực hiện: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    System.out.print("Nhập số sinh viên bạn muốn điền thông tin: ");
                    int size = Integer.parseInt(sc.nextLine());
                        for (int i = 0; i < size; i++) {
                            System.out.printf("Nhập thông tin SV thứ %d: ", currentIndex + 1);
                            arrStudent[currentIndex] = new Student();
                            System.out.println();
                            arrStudent[currentIndex].inputData(sc);
                            arrStudent[currentIndex].calAvgScore();
                            currentIndex++;
                    }
                    break;
                case 2:
                    float sum = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        sum += arrStudent[i].getAvgScore();
                    }
                    System.out.printf("Điểm trung bình của tất cả SV là: %.2f\n", (sum / currentIndex));
                    System.out.println();
                    break;
                case 3:
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("Thông tin SV thứ %d: ", i + 1);
                        arrStudent[i].displayData();
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Sắp xếp sinh viên theo điểm trung bình giảm dần: ");
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (arrStudent[i].getAvgScore() < arrStudent[j].getAvgScore()) {
                                Student temp = arrStudent[i];
                                arrStudent[i] = arrStudent[j];
                                arrStudent[j] = temp;
                            }
                        }
                    }

                    System.out.println("Đã xắp sếp SV theo thứ tự tăng dần");
                    break;
                case 5:
                    System.out.print("Nhập tên SV bạn muốn tìm: ");
                    String searchName = sc.nextLine();
                    int cntStudentNameSearch = 0;
                    System.out.println("Các SV muốn tìm là:");
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrStudent[i].getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                            arrStudent[i].displayData();
                            cntStudentNameSearch++;
                        }
                    }
                    if (cntStudentNameSearch == 0) {
                        System.out.println("Không tìm thấy SV");
                    }
                    break;
                case 6:
                    System.out.println("***********END***********");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 -> 5 để thực hiện chương trình");
            }
        }
        while (true);
    }
}
