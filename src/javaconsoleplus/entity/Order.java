package javaconsoleplus.entity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Order {
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("YYMM");
    SimpleDateFormat dateCRFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String orderId;
    private int quantity;
    private String productId;
    private String created;
    private int userCreatedId;
    private String updated;
    private int userUpdatedId;
    private boolean orderType;
    private float price;
    private boolean orderStatus;

    public Order() {
    }

    public Order(String orderId, int quantity, String productId, String created, int userCreatedId, String updated, int userUpdatedId, boolean orderType, float price, boolean orderStatus) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.productId = productId;
        this.created = created;
        this.userCreatedId = userCreatedId;
        this.updated = updated;
        this.userUpdatedId = userUpdatedId;
        this.orderType = orderType;
        this.price = price;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getUserCreatedId() {
        return userCreatedId;
    }

    public void setUserCreatedId(int userCreatedId) {
        this.userCreatedId = userCreatedId;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getUserUpdatedId() {
        return userUpdatedId;
    }

    public void setUserUpdatedId(int userUpdatedId) {
        this.userUpdatedId = userUpdatedId;
    }

    public boolean isOrderType() {
        return orderType;
    }

    public void setOrderType(boolean orderType) {
        this.orderType = orderType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void inputData(Scanner sc, Product[] arrProduct, int curIndexProduct, Employee[] arrEmpt, int curIndexEmp, Order[] arrOrder, int curIndexOrder, String impKey, String expKey) {
        boolean isExist = true;
        boolean isChecked;

        //Order ID
        String firstKeyId;
        if (impKey.isEmpty()) {
            firstKeyId = expKey;
        } else {
            firstKeyId = impKey;
        }

        String midleKeyId = dateFormat.format(date);
        int lastKeyId = 0;
        int maxId = 0;
        int numberOnly = 0;
        for (int i = 0; i < curIndexOrder; i++) {
            numberOnly = Integer.parseInt(arrOrder[i].getOrderId().replaceAll("^(PX|PN)-+[0-9]{4}-", ""));
            if (numberOnly > maxId) {
                maxId = numberOnly;
            }
        }
        lastKeyId = numberOnly + 1;
        this.orderId = firstKeyId + "-" + midleKeyId + "-" + (lastKeyId < 10 ? "0" + lastKeyId : lastKeyId);
        System.out.printf("Mã %s: %s\n",  firstKeyId == "PN" ? "phiếu nhập" : "phiếu xuất", this.orderId);

        //Order Type
        if (firstKeyId == "PN") {
            this.orderType = true;
        } else {
            this.orderType = false;
        }

        //Price
        System.out.print("Nhập giá thu: ");
        do {
            this.price = Integer.parseInt(sc.nextLine());
            if (this.price > 0) {
                break;
            } else {
                System.err.println("Vui lòng nhập giá lớn hơn 0");
            }
        } while (isExist);

        //Create Date
        this.created = dateCRFormat.format(date);
        System.out.printf("Ngày tạo %s: %s\n", firstKeyId == "PN" ? "phiếu nhập" : "phiếu xuất", this.created);

        //Quantity
        System.out.print("Nhập số lượng sản phẩm: ");
        do {
            this.quantity = Integer.parseInt(sc.nextLine());
            if (this.quantity > 0) {
                break;
            } else {
                System.err.println("Vui lòng nhập số  lớn hơn 0");
            }
        } while (isExist);

        //Product ID
        isChecked = false;
        isExist = true;
        System.out.println("Danh sách sản phẩm:");
        for (int i = 0; i < curIndexProduct; i++) {
            System.out.printf("Mã: %s - Tên: %s\n", arrProduct[i].getProductId(), arrProduct[i].getProductName());
        }
        System.out.print("Nhập mã sản phẩm: ");
        do {
            String choiseId = sc.nextLine();
            for (int i = 0; i < curIndexProduct; i++) {
                if (arrProduct[i].getProductId().equals(choiseId)) {
                    isChecked = true;
                    break;
                }
            }
            if (isChecked) {
                this.productId = choiseId;
                break;
            } else {
                System.err.println("Không tìm thấy mã sản phẩm trong list, vui lòng nhập lại");
            }
        } while (isExist);

        //Employee ID
        isChecked = false;
        isExist = true;
        System.out.println("Danh sách nhân viên:");
        for (int i = 0; i < curIndexEmp; i++) {
            System.out.printf("Mã: %s - Tên: %s\n", arrEmpt[i].getEmpId(), arrEmpt[i].getEmpName());
        }
        System.out.printf("Nhập mã nhân viên tạo %s: ", firstKeyId == "PN" ? "phiếu nhập" : "phiếu xuất");
        int choiseEmpId;
        do {
            choiseEmpId = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < curIndexEmp; i++) {
                if (arrEmpt[i].getEmpId() == choiseEmpId) {
                    isChecked = true;
                    break;
                }
            }
            if (isChecked) {
                this.userCreatedId = choiseEmpId;
                break;
            } else {
                System.err.println("Không tìm thấy mã nhân viên trong list, vui lòng nhập lại");
            }
        } while (isExist);

        //Order Status
        System.out.printf("Chọn trạng thái %s:\n", firstKeyId == "PN" ? "phiếu nhập" : "phiếu xuất");
        System.out.println("1. Hoạt động");
        System.out.println("2. Bị huỷ");
        System.out.print("Option: ");
        do {
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    this.orderStatus = true;
                    isExist = false;
                    break;
                case 2:
                    this.orderStatus = false;
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 2 option trên");
            }
        } while (isExist);
    }

    public void updateData(Scanner sc, Product[] arrProduct, int curIndexProduct, Employee[] arrEmpt, int curIndexEmp, Order[] arrOrder, int curIndexOrder, String impKey, String expKey) {
        boolean isExist = true;
        boolean isChecked;

        //Order ID
        String firstKeyId;
        if (impKey.isEmpty()) {
            firstKeyId = expKey;
        } else {
            firstKeyId = impKey;
        }

        //Update Date
        this.updated = dateCRFormat.format(date);
        System.out.printf("Ngày update %s: %s\n", firstKeyId == "PN" ? "phiếu nhập" : "phiếu xuất", this.updated);

        //Quantity
        System.out.print("Nhập số lượng sản phẩm: ");
        do {
            this.quantity = Integer.parseInt(sc.nextLine());
            if (this.quantity > 0) {
                break;
            } else {
                System.err.println("Vui lòng nhập số  lớn hơn 0");
            }
        } while (isExist);

        //Product ID
        isChecked = false;
        isExist = true;
        System.out.println("Danh sách sản phẩm:");
        for (int i = 0; i < curIndexProduct; i++) {
            System.out.printf("Mã: %s - Tên: %s\n", arrProduct[i].getProductId(), arrProduct[i].getProductName());
        }
        System.out.print("Nhập mã sản phẩm: ");
        do {
            String choiseId = sc.nextLine();
            for (int i = 0; i < curIndexProduct; i++) {
                if (arrProduct[i].getProductId().equals(choiseId)) {
                    isChecked = true;
                    break;
                }
            }
            if (isChecked) {
                this.productId = choiseId;
                break;
            } else {
                System.err.println("Không tìm thấy mã sản phẩm trong list, vui lòng nhập lại");
            }
        } while (isExist);

        //Employee ID
        isChecked = false;
        isExist = true;
        System.out.println("Danh sách nhân viên:");
        for (int i = 0; i < curIndexEmp; i++) {
            System.out.printf("Mã: %s - Tên: %s\n", arrEmpt[i].getEmpId(), arrEmpt[i].getEmpName());
        }
        System.out.printf("Nhập mã nhân viên update %s: ", firstKeyId == "PN" ? "phiếu nhập" : "phiếu xuất");
        int choiseEmpId;
        do {
            choiseEmpId = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < curIndexEmp; i++) {
                if (arrEmpt[i].getEmpId() == choiseEmpId) {
                    isChecked = true;
                    break;
                }
            }
            if (isChecked) {
                this.userUpdatedId = choiseEmpId;
                break;
            } else {
                System.err.println("Không tìm thấy mã nhân viên trong list, vui lòng nhập lại");
            }
        } while (isExist);

        //Order Type
        if (firstKeyId == "PN") {
            this.orderType = true;
        } else {
            this.orderType = false;
        }

        //Price
        System.out.print("Nhập giá thu: ");
        do {
            this.price = Integer.parseInt(sc.nextLine());
            if (this.price > 0) {
                break;
            } else {
                System.err.println("Vui lòng nhập giá lớn hơn 0");
            }
        } while (isExist);

        //Order Status
        System.out.printf("Chọn trạng thái %s:\n", firstKeyId == "PN" ? "phiếu nhập" : "phiếu xuất");
        System.out.println("1. Hoạt động");
        System.out.println("2. Bị huỷ");
        System.out.print("Option: ");
        do {
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    this.orderStatus = true;
                    isExist = false;
                    break;
                case 2:
                    this.orderStatus = false;
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 2 option trên");
            }
        } while (isExist);
    }

    public void displayData() {
        System.out.printf("Mã: %s\n", this.orderId);
        System.out.printf("Loại: %s\n", this.orderType ? "Phiếu nhập" : "Phiếu xuất");
        System.out.printf("Ngày tạo: %s\n", this.created);
        System.out.printf("Mã nhân viên tạo: %s\n", this.userCreatedId);
        System.out.printf("Ngày update: %s\n", this.updated == null ? "Chưa được cập nhật" : this.updated);
        System.out.printf("Mã nhân viên update: %s\n", this.userUpdatedId == 0 ? "Chưa được cập nhật" : this.userUpdatedId);
        System.out.printf("Mã sản phẩm: %s\n", this.productId);
        System.out.printf("Số lượng: %d\n", this.quantity);
        System.out.printf("Giá nhập: %.2f\n", this.price);
        System.out.printf("Trạng thái: %s\n", this.orderStatus ? "Hoạt động" : "Bị huỷ");
    }
}
