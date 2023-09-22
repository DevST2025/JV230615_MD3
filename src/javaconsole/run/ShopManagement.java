package javaconsole.run;

import javaconsole.entity.Categories;
import javaconsole.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    Categories[] arrCategories = new Categories[100];
    Product[] arrProduct = new Product[100];
    int currentIndexCategories = 0;
    int currentIndexProduct = 0;
    public static void main(String[] args) {
        ShopManagement shopManagement = new ShopManagement();
        Scanner sc = new Scanner(System.in);

        do {
            shopManagement.MenuShop(sc);
            System.out.print("Vui lòng chọn nội dung bạn muốn thực hiện: ");
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    boolean isExist = true;
                    do {
                        shopManagement.MenuCategories(sc);
                        System.out.print("Vui lòng chọn nội dung bạn muốn thực hiện: ");
                        choise = Integer.parseInt(sc.nextLine());
                        switch (choise) {
                            case 1:
                                shopManagement.inputCategories(sc);
                                break;
                            case 2:
                                shopManagement.displayCategories();
                                break;
                            case 3:
                                shopManagement.updateCategories(sc);
//                                shopManagement.displayCategories();
                                break;
                            case 4:
                                shopManagement.deleteCategories(sc);
                                break;
                            case 5:
                                shopManagement.updateStatusCategories(sc);
                                break;
                            case 6:
                                isExist = false;
                                break;
                            default:
                                System.err.println("Vui lòng chọn 1 trong 6 mục trên");
                        }
                    } while (isExist);
                    break;
                case 2:
                    isExist = true;
                    do {
                        shopManagement.MenuProduct(sc);
                        System.out.print("Vui lòng chọn nội dung bạn muốn thực hiện: ");
                        choise = Integer.parseInt(sc.nextLine());
                        switch (choise) {

                            case 1:
                                shopManagement.inputProduct(sc);
                                break;
                            case 2:
                                shopManagement.displayProduct();
                                break;
                            case 3:
                                shopManagement.sortProductByPrice();
                                shopManagement.displayProduct();
                                break;
                            case 4:
                                shopManagement.updateProduct(sc);
                                break;
                            case 5:
                                shopManagement.deleteProduct(sc);
                                break;
                            case 6:
                                shopManagement.searchProductByName(sc);
                                break;
                            case 7:
                                shopManagement.searchProductByPrice(sc);
                                break;
                            case 8:
                                isExist = false;
                                break;
                            default:
                                System.err.println("Vui lòng chọn 1 trong 8 mục trên");
                        }
                    } while (isExist);
                    break;
                case 3:
                    sc.close();
                    System.out.println("******************END*******************");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 3 mục trên");
            }
        } while (true);
    }


    /**
     * MENU
     * @param sc
     * author: THS
     */
    public void MenuShop(Scanner sc) {
        System.out.println("******************SHOP MENU*******************");
        System.out.println("1. Quản lý danh mục sản phẩm");
        System.out.println("2. Quản lý sản phẩm");
        System.out.println("3. Thoát");
    }
    public void MenuCategories(Scanner sc) {
        System.out.println("******************CATEGORIES MENU*******************");
        System.out.println("1. Nhập thông tin các danh mục");
        System.out.println("2. Hiển thị thông tin các danh mục");
        System.out.println("3. Cập nhật thông tin danh mục");
        System.out.println("4. Xóa danh mục");
        System.out.println("5. Cập nhật trạng thái danh mục");
        System.out.println("6. Thoát");
    }
    public void MenuProduct(Scanner sc) {
        System.out.println("******************PRODUCT MANAGEMENT*******************");
        System.out.println("1. Nhập thông tin các sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Sắp xếp các sản phẩm theo giá giảm dần");
        System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
        System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
        System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
        System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
        System.out.println("8. Thoát");
    }

    /**
     * Categories
     * @param sc
     * author:THS
     */
    //1. Nhập thông tin các danh mục
    public void inputCategories(Scanner sc) {
        System.out.print("Nhập số lượng danh mục: ");
        int cntCategories = Integer.parseInt(sc.nextLine());
        if (cntCategories > 0) {
            for (int i = 0; i < cntCategories; i++) {
                System.out.println("Nhập thông tin danh sách");
                arrCategories[currentIndexCategories] = new Categories();
                arrCategories[currentIndexCategories].inputData(sc, arrCategories, currentIndexCategories);
                currentIndexCategories++;
            }
            System.out.println();
        } else {
            System.err.println("Số lượng danh mục được nhập ít nhất là 1");
        }
    }

    //2. Hiển thị thông tin các danh mục
    public void displayCategories() {
        if (currentIndexCategories == 0) {
            System.err.println("Không có danh mục nào đã được tạo");
        }
        System.out.println("*****Thông tin danh mục*****");
        for (int i = 0; i < currentIndexCategories; i++) {
            if (arrCategories[i] != null) {
                System.out.printf("Thông tin danh mục %d: \n", i + 1);
                arrCategories[i].displayData();
                System.out.println("------");
            }
        }
        System.out.println("------");
    }

    //3. Cập nhật thông tin danh mục
    public void updateCategories(Scanner sc) {
        if (currentIndexCategories == 0) {
            System.err.println("Không có danh mục nào đã được tạo");

        } else {
            System.out.print("Nhập vào mã danh mục mà bạn muốn update: ");
            int catalogIdChoise = Integer.parseInt(sc.nextLine());
            boolean isChecked = true;
            for (int i = 0; i < currentIndexCategories; i++) {
                if (arrCategories[i].getCatalogId() == catalogIdChoise) {
                    arrCategories[i].updateData(sc, arrCategories, currentIndexCategories, i, arrCategories[i].getCatalogName());
                    isChecked = false;
                    break;
                }
            }
            if (isChecked) {
                System.err.println("Không tìm thấy danh mục");
            }
        }
    }

    //4. Xóa danh mục
    public void deleteCategories(Scanner sc) {
        boolean isChecked = false;
        int cntProduct = 0;
        int index = 0;
        System.out.print("Nhập vào mã danh mục mà bạn muốn xoá: ");
        int catalogIdChoise = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < currentIndexCategories; i++) {
            if (arrCategories[i].getCatalogId() == catalogIdChoise) {
                isChecked = true;
                index = i;
                break;
            }
        }
        if (isChecked) {
            for (int i = 0; i < currentIndexProduct; i++) {
                if (arrProduct[i].getCatalogId() == catalogIdChoise) {
                    cntProduct++;
                }
            }
            if (cntProduct == 0) {
                //Xoá thực hiện ở đây
                for (int i = index; i < currentIndexCategories; i++) {
                    arrCategories[i] = arrCategories[i + 1];
                }
                currentIndexCategories--;
                System.err.println("Đã xoá danh mục");
            } else {
                System.err.printf("Trong danh mục có %d sản phẩm, không thể xoá danh mục\n", cntProduct);
            }
        } else {
            System.err.println("Không tìm thấy danh mục");
        }
    }

    //5. Cập nhật trạng thái danh mục
    public void updateStatusCategories(Scanner sc) {
        System.out.print("Nhập mã danh mục cần cập nhật trạng thái: ");
        int catalogIdChoise = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < currentIndexCategories; i++) {
            if (arrCategories[i].getCatalogId() == catalogIdChoise) {
                arrCategories[i].setCatalogStatus(!(arrCategories[i].isCatalogStatus()));
            }
        }
        System.out.println("Đã đổi trạng thái danh mục");
    }

    /**
     *
     * @param sc
     */

    //1. Nhập thông tin các sản phẩm
    public void inputProduct(Scanner sc) {
        System.out.print("Nhập số lượng sản phẩm: ");
        int cntProduct = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cntProduct; i++) {
            System.out.println("Nhập thông tin sản phẩm");
            arrProduct[currentIndexProduct] = new Product();
            arrProduct[currentIndexProduct].inputData(sc, arrProduct, currentIndexProduct, arrCategories, currentIndexCategories);
            currentIndexProduct++;
        }
        System.out.println();
    }

    //2. Hiển thị thông tin các sản phẩm
    public void displayProduct() {
        System.out.println("*****Thông tin sản phẩm*****");
        for (int i = 0; i < currentIndexProduct; i++) {
            if (arrProduct[i] != null) {
                System.out.printf("Thông tin sản phẩm thứ %d: \n", i + 1);
                arrProduct[i].displayData();
                System.out.println("------");
            }
        }
        if (currentIndexProduct == 0) {
            System.err.println("Không có sản phẩm nào trong kho");
        }
        System.out.println("------");
    }

    //3. Sắp xếp các sản phẩm theo giá
    public void sortProductByPrice() {
        System.out.println("*****Sắp xếp các sản phẩm theo giá giảm dần*****");
        for (int i = 0; i < currentIndexProduct - 1; i++) {
            for (int j = i + 1; j < currentIndexProduct; j++) {
                if (arrProduct[i].getPrice() < arrProduct[j].getPrice() ) {
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sản phẩm theo giá giảm dần");
    }

    //4. Cập nhật thông tin sản phẩm theo mã sản phẩm
    public void updateProduct(Scanner sc) {
        System.out.print("Nhập vào mã sản phẩm mà bạn muốn update: ");
        String productIdChoise = sc.nextLine();
        boolean isChecked = true;
        for (int i = 0; i < currentIndexProduct; i++) {
            if (arrProduct[i].getProductId().equalsIgnoreCase(productIdChoise)) {
                arrProduct[i].updateData(sc, arrProduct, currentIndexProduct, arrCategories, currentIndexCategories, i, arrProduct[i].getProductName());
                isChecked = false;
                break;
            }
        }
        if (isChecked) {
            System.err.println("Không tìm thấy danh mục");
        }
    }

    //5. Xóa sản phẩm theo mã sản phẩm
    public void deleteProduct(Scanner sc) {
        boolean isChecked = false;
        int index = 0;
        System.out.print("Nhập vào mã sản phẩm mà bạn muốn xoá: ");
        String productIdChoise = sc.nextLine();
        for (int i = 0; i < currentIndexProduct; i++) {
            if (arrProduct[i].getProductId().equalsIgnoreCase(productIdChoise)) {
                isChecked = true;
                index = i;
                break;
            }
        }
        if (isChecked) {
            //Xoá thực hiện ở đây
            for (int i = index; i < currentIndexProduct; i++) {
                arrProduct[i] = arrProduct[i + 1];
            }
            currentIndexProduct--;
            System.err.println("Đã xoá sản phẩm");
        } else {
            System.err.println("Không tìm thấy sản phẩm");
        }
    }

    //6. Tìm kiếm các sản phẩm theo tên sản phẩm
    public void searchProductByName(Scanner sc) {
        int cntProduct = 0;
        System.out.print("Nhập tên sản phẩm cần search: ");
        String productNameSearch = sc.nextLine();
        for (int i = 0; i < currentIndexProduct; i++) {
            if (arrProduct[i].getProductName().toLowerCase().contains(productNameSearch.toLowerCase())) {
                System.out.printf("Sản phẩm thứ %d tìm được: \n", cntProduct + 1);
                arrProduct[i].displayData();
                cntProduct++;
            }
        }
        System.out.printf("Có %d sản phẩm tìm được\n", cntProduct);
    }

    //7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)
    public void searchProductByPrice(Scanner sc) {
        int cntProduct = 0;
        System.out.print("Nhập giá từ: ");
        float toPrice = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập giá từ: ");
        float fromPrice = Float.parseFloat(sc.nextLine());
        for (int i = 0; i < currentIndexProduct; i++) {
            if (arrProduct[i].getPrice() >= toPrice && arrProduct[i].getPrice() <= fromPrice) {
                System.out.printf("Sản phẩm thứ %d tìm được: \n", cntProduct + 1);
                arrProduct[i].displayData();
                cntProduct++;
            }
        }
        System.out.printf("Có %d sản phẩm tìm được trong khoảng giá từ %.2f đến %.2f\n", cntProduct, toPrice, fromPrice);
    }
}
