package plus.entity;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private float price;
    private String title;
    private String content;
    private boolean status;

    public Book() {}
    public Book(int bookId, String bookName, float price, String title, String content, boolean status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner sc) {
        System.out.print("Nhập mã sách: ");
        this.bookId = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên sách: ");
        this.bookName = sc.nextLine();
        System.out.print("Nhập giá sách: ");
        this.price = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập tiêu đề sách: ");
        this.title = sc.nextLine();
        System.out.print("Nhập nội dung sách: ");
        this.content = sc.nextLine();
        System.out.print("Nhập trạng thái sách: ");
        this.status = Boolean.parseBoolean(sc.nextLine());
    }
    public void displayData() {
        System.out.printf("Mã sách: %d- Tên sách: %s- Giá: %.2f\n", this.bookId, this.bookName, this.price);
        System.out.printf("Tiêu đề: %s- Nội dung: %s- Trạng thái: %b\n", this.title, this.content, this.status);
    }

}
