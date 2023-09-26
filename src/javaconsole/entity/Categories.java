package javaconsole.entity;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
    public void inputData(Scanner sc, Categories[] arrCategories, int index) {
        int maxId = 0;
        for (int i = 0; i < index; i++) {
            if (arrCategories[i].getCatalogId() > maxId) {
                maxId = arrCategories[i].getCatalogId();
            }
        }
        this.catalogId = maxId + 1;
        System.out.printf("Mã danh mục: %d\n", maxId + 1);
        System.out.print("Nhập tên danh mục: ");
        boolean isExist = true;
        boolean isChecked = true;
        do {
            this.catalogName = sc.nextLine();
            if (this.catalogName.length() <= 50) {
                for (int i = 0; i < index; i++) {
                    if (arrCategories[i].getCatalogName().equalsIgnoreCase(this.catalogName)) {
                        isChecked = false;
                        break;
                    }
                }
                if (isChecked) {
                    break;
                } else {
                    System.err.println("Tên danh mục đã tồn tại");
                    isChecked = true;
                }
            } else {
                System.out.println("Tên danh mục không được vượt qua 50 kí tự");
            }
        } while (isExist);
        System.out.print("Nhập mô tả danh mục: ");
        this.descriptions = sc.nextLine();
        System.out.println("Trạng thái danh mục: ");
        System.out.println("1. Hoạt động");
        System.out.println("2. Không hoạt động");
        System.out.print("Trạng thái danh mục mà bạn chọn: ");
        int choise = Integer.parseInt(sc.nextLine());

        switch (choise) {
            case 1:
                this.catalogStatus = true;
                break;
            case 2:
                this.catalogStatus = false;
                break;
            default:
                System.out.println("Vui lòng chọn 1 trong 2 hoạt động trên");
        }
    }

    public void updateData(Scanner sc, Categories[] arrCategories, int index, int indexSelectCategories, String oldName) {
        System.out.print("Update tên danh mục: ");
        boolean isExist = true;
        boolean isChecked = true;
        do {
            this.catalogName = sc.nextLine();
            //Trường hợp người dùng không nhập gì cả thì giữ nguyên tên cũ
            if (this.catalogName.isEmpty()) {
                this.catalogName = oldName;
            }
            if (this.catalogName.length() <= 50) {
                for (int i = 0; i < index; i++) {
                    if (i == indexSelectCategories) {
                        continue;
                    }
                    if (arrCategories[i].getCatalogName().equalsIgnoreCase(this.catalogName)) {
                        isChecked = false;
                        break;
                    }
                }
                if (isChecked) {
                    break;
                } else {
                    System.err.println("Tên danh mục đã tồn tại");
                    isChecked = true;
                }
            } else {
                System.out.println("Tên danh mục không được vượt qua 50 kí tự");
            }
        } while (isExist);
        System.out.print("Nhập mô tả danh mục: ");
        this.descriptions = sc.nextLine();
        System.out.println("Trạng thái danh mục: ");
        System.out.println("1. Hoạt động");
        System.out.println("2. Không hoạt động");
        System.out.print("Trạng thái danh mục mà bạn chọn: ");
        int choise = Integer.parseInt(sc.nextLine());

        switch (choise) {
            case 1:
                this.catalogStatus = true;
                break;
            case 2:
                this.catalogStatus = false;
                break;
            default:
                System.out.println("Vui lòng chọn 1 trong 2 hoạt động trên");
        }
    }
    public void displayData() {
        System.out.printf("Mã: %d\n", this.catalogId);
        System.out.printf("Tên: %s\n", this.catalogName);
        System.out.printf("Mô tả: %s\n", this.descriptions);
        System.out.printf("Trạng thái: %s\n", this.catalogStatus ? "Hoạt động" : "Không hoạt động");
    }
}
