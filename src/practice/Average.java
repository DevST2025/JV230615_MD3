package practice;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập điểm môn Toán: ");
        double toan = scanner.nextDouble();

        System.out.print("Nhập điểm môn Lý: ");
        double ly = scanner.nextDouble();

        System.out.print("Nhập điểm môn Hoá: ");
        double hoa = scanner.nextDouble();

        System.out.print("Nhập điểm môn Văn: ");
        double van = scanner.nextDouble();

        System.out.print("Nhập điểm môn Tiếng Anh: ");
        double tienganh = scanner.nextDouble();

        double diemTrungBinh = (toan + ly + hoa + van + tienganh) / 5;

        System.out.println("Điểm trung bình các môn: " + diemTrungBinh);

        if (diemTrungBinh < 5) {
            System.out.println("Xếp loại học lực: Yếu");
        } else if (diemTrungBinh < 6.5) {
            System.out.println("Xếp loại học lực: Trung bình");
        } else if (diemTrungBinh < 8) {
            System.out.println("Xếp loại học lực: Khá");
        } else if (diemTrungBinh < 9) {
            System.out.println("Xếp loại học lực: Giỏi");
        } else {
            System.out.println("Xếp loại học lực: Xuất sắc");
        }
        scanner.close();
    }
}
