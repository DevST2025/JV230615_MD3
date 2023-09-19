package plus.imp;

import plus.entity.Book;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book book1 = new Book();
        Book book2 = new Book(1, "BookName1", 10, "title1", "content1", true);

        do {
            System.out.println("***********MENU***********");
            System.out.println("1. Nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin sách");
            System.out.println("3. In thông tin giá sách");
            System.out.println("4. Cập nhật trạng thái sách");
            System.out.println("5. Thoát");
            System.out.print("Chọn số mà bạn muốn thực hiện: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    book1.inputData(sc);
                    break;
                case 2:
                    book1.displayData();
                    break;
                case 3:
                    book1.getPrice();
                    break;
                case 4:
                    System.out.print("Nhập giá mới cho sách: ");
                    float newPrice = Float.parseFloat(sc.nextLine());
                    book1.setPrice(newPrice);
                    break;
                case 5:
                    System.out.println("***********END***********");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 -> 5 để thực hiện chương trình");
            }
        }
        while (true);
    }
}
