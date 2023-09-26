package javaconsoleplus.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    private String productId;
    private String productName;
    private String manufacturer;
    private boolean productStatus;

    public Product() {
    }

    public Product(String productId, String productName, String manufacturer, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
    public void inputData(Scanner sc, Product[] arrProduct, int curIndexProduct) {
        boolean isExist = true;
        boolean isChecked;

        //Product ID
        System.out.print("Nhập mã sản phẩm: ");
        isChecked = true;
        do {
            this.productId = sc.nextLine();
            if (this.productId.length() == 4) {
                for (int i = 0; i < curIndexProduct; i++) {
                    if (arrProduct[i].getProductId().equals(this.productId)) {
                        isChecked = false;
                    }
                }
                if (isChecked) {
                    if (Pattern.matches("^[A-Z][a-zA-Z0-9]{3}$", this.productId)) {
                        break;
                    } else {
                        System.err.println("Mã bắt đầu bằng chữ cái đầu in hoa và mã không bao gồm các ký tự dặc biệt ");
                    }
                } else {
                    System.err.println("Mã sản phẩm đã tồn tại");
                    isChecked = true;
                }
            } else {
                System.err.println("Vui lòng nhập 4 ký tự");
            }
        } while (isExist);

        //Product Name
        isChecked = true;
        System.out.print("Nhập tên sản phẩm: ");
        do {
            this.productName = sc.nextLine();
            if (this.productName.length() > 0) {
                for (int i = 0; i < curIndexProduct; i++) {
                    if (arrProduct[i].getProductName().equalsIgnoreCase(this.productName)) {
                        isChecked = false;
                    }
                }
                if (isChecked) {
                    break;
                } else {
                    System.err.println("Tên sản phẩm đã tồn tại");
                    isChecked = true;
                }
            } else {
                System.err.println("Tên sản phẩm phải ít nhất 1 ký tự");
            }

        } while (isChecked);

        //Manufacturer
        System.out.print("Nhập tên nhà sản xuất: ");
        this.manufacturer = sc.nextLine();

        //Product Status
        System.out.println("Chọn trạng thái sản phẩm: ");
        System.out.println("0. Hoạt động");
        System.out.println("1. Không hoạt động");
        System.out.print("Option: ");
        do {
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 0:
                    this.productStatus = true;
                    isExist = false;
                    break;
                case 1:
                    this.productStatus = false;
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 2 option trên");
            }
        } while (isExist);
    }

    public void updateData(Scanner sc, Product[] arrProduct, int curIndexProduct, int curIndex, String curProductName) {
        boolean isExist = true;
        boolean isChecked;

        //Product Name
        isChecked = true;
        System.out.print("Nhập tên sản phẩm: ");
        do {
            this.productName = sc.nextLine();
            if (this.productName.isEmpty()) {
                this.productName = curProductName;
                break;
            }
            if (this.productName.length() > 0) {
                for (int i = 0; i < curIndexProduct; i++) {
                    if (arrProduct[i] == arrProduct[curIndex]) {
                        continue;
                    }
                    if (arrProduct[i].getProductName().equalsIgnoreCase(this.productName)) {
                        isChecked = false;
                    }
                }
                if (isChecked) {
                    break;
                } else {
                    System.err.println("Tên sản phẩm đã tồn tại");
                    isChecked = true;
                }
            } else {
                System.err.println("Tên sản phẩm phải ít nhất 1 ký tự");
            }

        } while (isChecked);

        //Manufacturer
        System.out.print("Nhập tên nhà sản xuất: ");
        this.manufacturer = sc.nextLine();

        //Product Status
        System.out.println("Chọn trạng thái sản phẩm: ");
        System.out.println("0. Hoạt động");
        System.out.println("1. Không hoạt động");
        System.out.print("Option: ");
        do {
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 0:
                    this.productStatus = true;
                    isExist = false;
                    break;
                case 1:
                    this.productStatus = false;
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 2 option trên");
            }
        } while (isExist);
    }

    public void displayData() {
        System.out.printf("Mã: %s\n", this.productId);
        System.out.printf("Tên: %s\n", this.productName);
        System.out.printf("Nhà sản xuất: %s\n", this.manufacturer);
        System.out.printf("Trạng thái: %s\n", this.productStatus ? "Hoạt động" : "Không hoạt động");
    }
}

