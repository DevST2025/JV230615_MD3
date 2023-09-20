package ra.imp;

import ra.entity.Product;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] arrProduct = new Product[100];
        int currentIndex = 0;

        do {
            System.out.println("**********************MENU*********************");
            System.out.println("1. Nhập vào thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Chọn số mà bạn muốn thực hiện: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    System.out.print("Nhập số sản phẩm bạn muốn điền thông tin: ");
                    int cntProduct = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < cntProduct; i++) {
                        System.out.printf("Nhập thông tin SP thứ %d: \n", currentIndex + 1);
                        arrProduct[currentIndex] = new Product();
                        arrProduct[currentIndex].inputData(sc, arrProduct, currentIndex);
                        currentIndex++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("Thông tin SP thứ %d: \n", i + 1);
                        arrProduct[i].displayData();
                    }
                    break;
                case 3:
                    for (int i = 0; i < currentIndex; i++) {
                        arrProduct[i].calProfit();
                    }
                    System.out.println("Đã tính lợi nhuận các sản phẩm");
                    System.out.println();
                    break;
                case 4:
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (arrProduct[i].getProfit() < arrProduct[j].getProfit()) {
                                Product temp = arrProduct[i];
                                arrProduct[i] = arrProduct[j];
                                arrProduct[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("Thông tin SP thứ %d: \n", i + 1);
                        arrProduct[i].displayData();
                    }
                    break;
                case 5:
                    int cntFindtoPrice = 0;
                    System.out.print("Nhập giá sản phẩm bắt đầu từ: ");
                    float fromPrice = Float.parseFloat(sc.nextLine());
                    System.out.print("Nhập giá sản phẩm kết thúc: ");
                    float toPrice = Float.parseFloat(sc.nextLine());
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrProduct[i].getExportPrice() >= fromPrice && arrProduct[i].getExportPrice() <= toPrice) {
                            cntFindtoPrice++;
                        }
                    }
                    if (cntFindtoPrice == 0) {
                        System.out.printf("Không có sản phẩm nào nằm trong khoảng giá từ %.2f đến %.2f", fromPrice,toPrice);
                    } else {
                        System.out.printf("Có %d sản phẩm nằm trong khoảng giá từ %.2f đến %.2f", cntFindtoPrice, fromPrice,toPrice);
                    }
                    System.out.println();
                    break;
                case 6:
                    int cntFindtoName = 0;
                    System.out.print("Nhập tên SP bạn muốn tìm: ");
                    String productNameSearch = sc.nextLine();
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrProduct[i].getProductName().toLowerCase().contains(productNameSearch.toLowerCase())) {
                            cntFindtoName++;
                            arrProduct[i].displayData();
                        }
                    }
                    if (cntFindtoName == 0) {
                        System.out.println("Không có sản phẩm nào được tìm thấy");
                    } else {
                        System.out.printf("Có %d sản phẩm được tìm thấy", cntFindtoName);
                    }
                    System.out.println();
                    break;
                case 7:
                    boolean isCheck = true;
                    System.out.print("Nhập vào mã sản phẩm bạn muốn thêm số lượng: ");
                    String productIdFind = sc.nextLine();
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrProduct[i].getProductId().equalsIgnoreCase(productIdFind)) {
                            isCheck = false;
                            System.out.print("Nhập số lượng muốn thêm: ");
                            int addQuantity = Integer.parseInt(sc.nextLine());
                            arrProduct[i].setQuantity(arrProduct[i].getQuantity() + addQuantity);
                            break;
                        }
                    }
                    if (isCheck) {
                        System.out.println("Không tìm thấy sản phẩm");
                    }
                    System.out.println();
                    break;
                case 8:
                    isCheck = true;
                    System.out.print("Nhập vào tên sản phẩm bạn bán: ");
                    String productNameSell = sc.nextLine();
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrProduct[i].getProductName().equalsIgnoreCase(productNameSell)) {
                            isCheck = false;
                            System.out.print("Nhập số lượng muốn bán: ");
                            int removeQuantity = Integer.parseInt(sc.nextLine());
                            if (removeQuantity > arrProduct[i].getQuantity()) {
                                System.out.println("Số lượng bán không vượt quá số lượng trong kho");
                            } else {
                                arrProduct[i].setQuantity(arrProduct[i].getQuantity() - removeQuantity);
                                break;
                            }
                        }
                    }
                    if (isCheck) {
                        System.out.println("Không tìm thấy sản phẩm");
                    }
                    System.out.println();
                    break;
                case 9:
                    isCheck = true;
                    System.out.print("Nhập vào mã sản phẩm bạn muốn thay đổi trạng thái: ");
                    String productIdChangeSST = sc.nextLine();
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrProduct[i].getProductId().equalsIgnoreCase(productIdChangeSST)) {
                            isCheck = false;
                            arrProduct[i].setStatus(!(arrProduct[i].isStatus()));
                            break;
                        }
                    }
                    if (isCheck) {
                        System.out.println("Không tìm thấy sản phẩm");
                    }
                    System.out.println();
                    break;
                case 10:
                    sc.close();
                    System.out.println("**********************END*********************");
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn option trong khoảng 1 -> 10");
            }
        }
        while (true);
    }

}
