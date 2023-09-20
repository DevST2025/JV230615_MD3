package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
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

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner sc, Product[] arrProduct, int currentIndex) {
        System.out.print("Nhập mã sản phẩm: ");
        boolean isExist = true;
        boolean isCheck = true;
        do {
            this.productId = sc.nextLine();
            if (this.productId.length() == 4) {
                for (int i = 0; i < currentIndex; i++) {
                    if (arrProduct[i].getProductId().equalsIgnoreCase(this.productId)) {
                        isCheck = false;
                        break;
                    }
                }
                if (isCheck) {
                    break;
                } else {
                    System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại");
                    isCheck = true;
                }
            } else {
                System.err.println("Vui lòng nhập mã sản phẩm gồm 4 ký tự");
            }

        }
        while (isExist);

        System.out.print("Nhập tên sản phẩm: ");
        isCheck = true;
        do {
            this.productName = sc.nextLine();
            if (this.productName.length() >= 6 && this.productName.length() <= 50) {
                for (int i = 0; i < currentIndex; i++) {
                    if (arrProduct[i].getProductName().equalsIgnoreCase(this.productName)) {
                        isCheck = false;
                        break;
                    }
                }
                if (isCheck) {
                    break;
                } else {
                    System.err.println("Tên sản đã tồn tại, vui lòng nhập lại");
                    isCheck = true;
                }
            } else {
                System.err.println("Vui lòng nhập tên sản phẩm – gồm 6-50 ký tự");
            }
        }
        while (isExist);
        System.out.print("Nhập giá nhập sản phẩm: ");
        do {
            this.importPrice = Float.parseFloat(sc.nextLine());
            if (this.importPrice > 0) {
                break;
            } else {
                System.err.println("Vui lòng nhập giá nhập có giá trị lớn hơn 0");
            }
        }
        while (isExist);
        System.out.print("Nhập giá bán sản phẩm: ");
        do {
            this.exportPrice = Float.parseFloat(sc.nextLine());
            if (this.exportPrice > this.importPrice * 1.2) {
                break;
            } else {
                System.err.println("Vui lòng Giá xuất có giá trị lớn hơn ít nhất 20% so với giá nhập");
            }
        }
        while (isExist);
        System.out.print("Nhập số lượng sản phẩm: ");
        do {
            this.quantity = Integer.parseInt(sc.nextLine());
            if (this.quantity > 0) {
                break;
            } else {
                System.err.println("Vui lòng nhập  số lượng sản phẩm lớn hơn 0");
            }
        }
        while (isExist);
        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = sc.nextLine();
        System.out.println("Chọn trạng thái sản sản phẩm: ");
        System.out.println("1. Đang bán");
        System.out.println("2. Không bán");
        int choise = Integer.parseInt(sc.nextLine());
        switch (choise) {
            case 1:
                this.status = true;
                break;
            case 2:
                this.status = false;
            default:
                System.out.println("Vui lòng nhập 1 trong 2");
        }
//        do {
//            String statusString = sc.nextLine();
//            if (statusString.equalsIgnoreCase("dang ban") || statusString.equalsIgnoreCase("khong ban")) {
//                if (statusString.equalsIgnoreCase("dang ban")) {
//                    statusString = "true";
//                    this.status = Boolean.parseBoolean(statusString);
//                    break;
//                }
//                if (statusString.equalsIgnoreCase("khong ban")) {
//                    statusString = "false";
//                    this.status = Boolean.parseBoolean(statusString);
//                    break;
//                }
//            } else {
//                System.err.println("Vui lòng nhập  \"dang ban\" hoặc \"khong ban\"");
//            }
//        }
//        while (isExist);
    }

    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice;
    }

    public void displayData() {
        System.out.printf("Mã SP: %s - Tên SP: %s - Giá nhập: %.2f đồng - Giá bán: %.2f đồng\n", this.productId, this.productName, this.importPrice, this.exportPrice);
        System.out.printf("Lợi nhuận: %.2f đồng - Số lượng: %d cái - Mô tả: %s- Trạng thái: %s\n", this.profit, this.quantity, this.descriptions, this.status ? "Đang bán" : "Không bán");
    }
}
