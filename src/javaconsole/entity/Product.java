package javaconsole.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
    private Date date = null;
    private String productId;
    private String productName;
    private float price;
    private String description;
    private String created;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(Date date, String productId, String productName, float price, String description, String created, int catalogId, int catalogStatus) {
        this.date = date;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = catalogStatus;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) {
        this.date = date;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getCatalogStatus() {
        return productStatus;
    }

    public void setCatalogStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner sc, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCategories) {
        boolean isExist = true;

        //CataLog ID
        System.out.println("Chọn danh mục sản phẩm");
        for (int i = 0; i < indexCategories; i++) {
            System.out.printf("%d. %s\n", (i + 1), arrCategories[i].getCatalogName());
        }
        System.out.print("Lựa chọn của bạn: ");
        do {
            int choise = Integer.parseInt(sc.nextLine());
            if (choise >= 1 && choise <= indexCategories) {
                this.catalogId = arrCategories[choise - 1].getCatalogId();
                System.out.printf("Mã danh mục của sản phẩm: %d\n", this.catalogId);
                break;
            } else {
                System.err.printf("Vui lòng chọn 1 trong khoảng %d option trên\n", indexCategories);
            }
        } while (isExist);


        //Product ID
        System.out.print("Nhập mã sản phẩm sản phẩm: ");
        boolean isChecked = true;
        do {
            this.productId = sc.nextLine();
            if (this.productId.length() == 4) {
                for (int i = 0; i < indexProduct; i++) {
                    if (arrProduct[i].getProductId().equalsIgnoreCase(this.productId)) {
                        isChecked = false;
                        break;
                    }
                }
                if (isChecked) {
                    if (Pattern.matches("[CSAcsa][a-zA-Z0-9]{3}$", this.productId)) {
                        break;
                    } else {
                        System.err.println("Mã phải 4 kí bắt đầu bằng C hoặc S hoặc A");
                        isChecked = true;
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
        System.out.print("Nhập tên sản phẩm: ");
        isChecked = true;
        do {
            this.productName = sc.nextLine();
            if (this.productName.length() >= 10 && this.productName.length() <= 50) {
                for (int i = 0; i < indexProduct; i++) {
                    if (arrProduct[i].getProductName().equalsIgnoreCase(this.productName)) {
                        isChecked = false;
                        break;
                    }
                }
                if (isChecked) {
                    break;
                } else {
                    System.err.println("Tên sản phẩm đã tồn tại");
                }
            } else {
                System.err.println("Vui lòng nhập gồm 10 - 50 ký tự");
            }
        } while (isExist);

        //Price
        System.out.print("Nhập giá sản phẩm: ");
        do {
            this.price = Float.parseFloat(sc.nextLine());
            if (this.price > 0) {
                break;
            } else {
                System.err.println("Vui lòng nhập giá lớn hơn 0");
            }
        } while (isExist);

        //Description
        System.out.print("Nhập mô tả danh mục: ");
        this.description = sc.nextLine();

        //Date
        System.out.print("Nhập ngày nhập sản phẩm có định dạng dd/mm/yyyy: ");
        this.created = sc.nextLine();
        try {
            //Parsing the String
            date = dateFormat.parse(this.created);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Status
        System.out.println("Trạng thái danh mục: ");

        System.out.println("0. Đang bán");
        System.out.println("1. Hết hàng");
        System.out.println("2. Không bán");
        do {
            System.out.print("Trạng thái danh mục mà bạn chọn: ");
            int choise = Integer.parseInt(sc.nextLine());
            if (choise < 0 || choise > 2) {
                System.err.println("Vui lòng nhập số trong khoảng 0-2");
            } else {
                this.productStatus = choise;
                break;
            }

        } while (isExist);
    }

    public void updateData(Scanner sc, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCategories, int indexSelectProduct, String oldName) {
        boolean isExist = true;

        //CataLog ID
        System.out.println("Chọn danh mục sản phẩm");
        for (int i = 0; i < indexCategories; i++) {
            System.out.printf("%d. %s\n", (i + 1), arrCategories[i].getCatalogName());
        }
        System.out.print("Lựa chọn của bạn: ");
        int choise = Integer.parseInt(sc.nextLine());
        this.catalogId = arrCategories[choise - 1].getCatalogId();
        System.out.printf("Mã danh mục của sản phẩm này là: %d\n", this.catalogId);

        //Product Name
        System.out.print("Nhập tên sản phẩm: ");
        boolean isChecked = true;
        do {
            this.productName = sc.nextLine();
            //Trường hợp người dùng không nhập gì cả thì giữ nguyên tên cũ
            if (this.productName.isEmpty()) {
                this.productName = oldName;
            }
            if (this.productName.length() >= 10 && this.productName.length() <= 50) {
                for (int i = 0; i < indexProduct; i++) {
                    if (i == indexSelectProduct) {
                        continue;
                    }
                    if (arrProduct[i].getProductName().equalsIgnoreCase(this.productName)) {
                        isChecked = false;
                        break;
                    }
                }
                if (isChecked) {
                    break;
                } else {
                    System.err.println("Tên sản phẩm đã tồn tại");
                    isChecked = true;
                }
            } else {
                System.err.println("Vui lòng nhập gồm 10 - 50 ký tự");
            }
        } while (isExist);

        //Price
        System.out.print("Nhập giá sản phẩm: ");
        do {
            this.price = Float.parseFloat(sc.nextLine());
            if (this.price > 0) {
                break;
            } else {
                System.err.println("Vui lòng nhập giá lớn hơn 0");
            }
        } while (isExist);

        //Description
        System.out.print("Nhập mô tả danh mục: ");
        this.description = sc.nextLine();

        //Date
        System.out.print("Nhập ngày nhập sản phẩm có định dạng dd/mm/yyyy: ");
        this.created = sc.nextLine();
        try {
            //Parsing the String
            date = dateFormat.parse(this.created);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Status
        System.out.println("Trạng thái danh mục: ");

        System.out.println("0. Đang bán");
        System.out.println("1. Hết hàng");
        System.out.println("2. Không bán");
        do {
            System.out.print("Trạng thái danh mục mà bạn chọn: ");
            choise = Integer.parseInt(sc.nextLine());
            if (choise < 0 || choise > 2) {
                System.err.println("Vui lòng nhập số trong khoảng 0-2");
            } else {
                this.productStatus = choise;
                break;
            }

        } while (isExist);
    }


    public void displayData() {
        String status = "Không rõ trạng thái";
        switch (this.productStatus) {
            case 0:
                status = "Đang bán";
            case 1:
                status = "Hết hàng";
            case 2:
                status = "Không bán";
        }
        System.out.printf("Mã danh mục: %d\n", this.catalogId);
        System.out.printf("Mã sản phẩm: %s\n", this.productId);
        System.out.printf("Tên: %s\n", this.productName);
        System.out.printf("Giá: %.2f VND\n", this.price);
        System.out.printf("Mô tả: %s\n", this.description);
        System.out.printf("Ngày nhập: ngày %td, tháng %1$tm, năm %1$tY\n", date);
        System.out.printf("Trạng thái: %s\n", status);
    }
}
