package javaconsoleplus.run;

import javaconsoleplus.entity.Employee;
import javaconsoleplus.entity.Order;
import javaconsoleplus.entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StoreManagement {
    static Product[] arrProduct = new Product[100];
    static Employee[] arrEmployee = new Employee[100];
    static Order[] arrOrder = new Order[100];
    static int curIndexProduct = 0;
    static int curIndexEmp = 0;
    static int curIndexOrder = 0;
    static Scanner sc = new Scanner(System.in);
    static Date date = null;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {

        do {
            System.out.println("********************STORE MANAGEMENT***************");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Quản lý phiếu nhập");
            System.out.println("4. Quản lý phiếu xuất");
            System.out.println("5. Báo cáo thống kê");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    productMenu();
                    break;
                case 2:
                    employeeMenu();
                    break;
                case 3:
                    receiptMenu();
                    break;
                case 4:
                    billMenu();
                    break;
                case 5:
                    reportMenu();
                    break;
                case 6:
                    sc.close();
                    System.out.println("********************END***************");
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn 1 trong 6 option trên");
            }

        } while (true);

    }

    /**
     * Product Menu
     */
    static void productMenu() {
        boolean isExist = true;
        do {
            System.out.println("********************PRODUCT MANAGEMENT***************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Tìm kiếm sản phẩm theo tên");
            System.out.println("5. Cập nhật trạng thái sản phẩm");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    inputDataProduct();
                    break;
                case 2:
                    displayDataProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    searchProductByName();
                    break;
                case 5:
                    updateStatusProduct();
                    break;
                case 6:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 6 option trên");
            }
        } while (isExist);
    }

    //1. Nhập thông tin các sản phẩm
    private static void inputDataProduct() {
        System.out.println("Nhập số lượng sản phẩm muốn điền thông tin: ");
        int inputQuantity = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < inputQuantity; i++) {
            arrProduct[curIndexProduct] = new Product();
            System.out.printf("Sản phẩm thứ %d: \n", curIndexProduct + 1);
            arrProduct[curIndexProduct].inputData(sc, arrProduct, curIndexProduct);
            curIndexProduct++;
            System.out.println("-----------------");
        }
    }

    //2. Hiển thị thông tin các sản phẩm
    private static void displayDataProduct() {
        System.out.println("Thông tin các sản phẩm");
        if (curIndexProduct == 0) {
            System.err.println("Hiện tại chưa có sản phẩm nào trong kho");
        }
        for (int i = 0; i < curIndexProduct; i++) {
            System.out.printf("Thông tin sản phẩm thứ %d: \n", i + 1);
            arrProduct[i].displayData();
            System.out.println("-----------------");
        }
    }

    //3. Cập nhật thông tin sản phẩm
    private static void updateProduct() {
        boolean isChecked = true;
        System.out.println("Nhập vào mã sản phẩm bạn muốn update");
        String productIdChoise = sc.nextLine();
        for (int i = 0; i < curIndexProduct; i++) {
            if (arrProduct[i].getProductId().equals(productIdChoise)) {
                arrProduct[i].updateData(sc, arrProduct, curIndexProduct, i, arrProduct[i].getProductName());
                isChecked = false;
                break;
            }
        }
        if (isChecked) {
            System.err.printf("Không tìm thấy sản phẩm có mã %s\n", productIdChoise);
        } else {
            System.out.println("Sản phẩm đã được update");
        }
    }

    //4. Tìm kiếm sản phẩm theo tên
    private static void searchProductByName() {
        int cntProduct = 0;
        System.out.print("Search: ");
        String productNameSearch = sc.nextLine();
        for (int i = 0; i < curIndexProduct; i++) {
            if (arrProduct[i].getProductName().toLowerCase().contains(productNameSearch.toLowerCase())) {
                System.out.printf("Thông tin sản phẩm thứ %d: \n", cntProduct + 1);
                arrProduct[i].displayData();
                System.out.println("-----------------");
                cntProduct++;
            }
        }
        if (cntProduct == 0) {
            System.err.println("Không có sản phẩm nào được tìm thấy");
        } else {
            System.out.printf("Có %d sản phầm được tìm thấy\n", cntProduct);
        }
    }

    //5. Cập nhật trạng thái sản phẩm
    private static void updateStatusProduct() {
        boolean isChecked = true;
        System.out.println("Nhập vào mã sản phẩm bạn muốn update");
        String productIdChoise = sc.nextLine();
        for (int i = 0; i < curIndexProduct; i++) {
            if (arrProduct[i].getProductId().equals(productIdChoise)) {
                arrProduct[i].setProductStatus(!arrProduct[i].isProductStatus());
                isChecked = false;
                break;
            }
        }
        if (isChecked) {
            System.err.printf("Không tìm thấy sản phẩm có mã %s\n", productIdChoise);
        } else {
            System.out.println("Sản phẩm đã được update");
        }
    }

    /**
     * Employee Menu
     */
    static void employeeMenu() {
        boolean isExist = true;
        do {
            System.out.println("********************PRODUCT MANAGEMENT***************");
            System.out.println("1. Nhập thông tin nhân viên");
            System.out.println("2. Hiển thị thông tin nhân viên");
            System.out.println("3. Cập nhật thông tin nhân viên");
            System.out.println("4. Tìm nhân viên theo tên nhân viên");
            System.out.println("5. Cập nhật trạng thái của nhân viên");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    inputDataEmp();
                    break;
                case 2:
                    displayDataEmp();
                    break;
                case 3:
                    updateEmp();
                    break;
                case 4:
                    searchEmpByName();
                    break;
                case 5:
                    updateStatusEmp();
                    break;
                case 6:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 6 option trên");
            }
        } while (isExist);

    }

    //1. Nhập thông tin nhân viên
    private static void inputDataEmp() {
        System.out.println("Nhập số lượng nhân viên muốn điền thông tin: ");
        int inputQuantity = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < inputQuantity; i++) {
            arrEmployee[curIndexEmp] = new Employee();
            System.out.printf("Nhân viên thứ %d: \n", curIndexEmp + 1);
            arrEmployee[curIndexEmp].inputData(sc, arrEmployee, curIndexEmp);
            curIndexEmp++;
            System.out.println("-----------------");
        }
    }

    //2. Hiển thị thông tin nhân viên
    private static void displayDataEmp() {
        System.out.println("Thông tin các nhân viên");
        if (curIndexEmp == 0) {
            System.err.println("Hiện tại chưa có nhân viên");
        }
        for (int i = 0; i < curIndexEmp; i++) {
            System.out.printf("Thông tin nhân viên thứ %d: \n", i + 1);
            arrEmployee[i].displayData();
            System.out.println("-----------------");
        }
    }

    //3. Cập nhật thông tin nhân viên
    private static void updateEmp() {
        boolean isChecked = true;
        System.out.println("Nhập vào mã nhân viên bạn muốn update");
        int empIdChoise = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < curIndexEmp; i++) {
            if (arrEmployee[i].getEmpId() == empIdChoise) {
                arrEmployee[i].updateData(sc, arrEmployee, curIndexEmp, i, arrEmployee[i].getEmpName());
                isChecked = false;
                break;
            }
        }
        if (isChecked) {
            System.err.printf("Không tìm thấy nhân viên nào có mã %s\n", empIdChoise);
        } else {
            System.out.println("Nhân viên đã được update");
        }
    }

    //4. Tìm nhân viên theo tên nhân viên
    private static void searchEmpByName() {
        int cntEmp = 0;
        System.out.print("Search: ");
        String empNameSearch = sc.nextLine();
        for (int i = 0; i < curIndexEmp; i++) {
            if (arrEmployee[i].getEmpName().toLowerCase().contains(empNameSearch.toLowerCase())) {
                System.out.printf("Thông tin nhân viên thứ %d: \n", cntEmp + 1);
                arrEmployee[i].displayData();
                System.out.println("-----------------");
                cntEmp++;
            }
        }
        if (cntEmp == 0) {
            System.err.println("Không có nhân viên nào được tìm thấy");
        } else {
            System.out.printf("Có %d nhân viên được tìm thấy\n", cntEmp);
        }
    }

    //5. Cập nhật trạng thái của nhân viên
    private static void updateStatusEmp() {
        boolean isChecked = true;
        boolean isExist = true;
        System.out.println("Nhập vào mã nhân viên bạn muốn update");
        int empIdChoise = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < curIndexEmp; i++) {
            if (arrEmployee[i].getEmpId() == empIdChoise) {
                System.out.println("Chọn tình trạng: ");
                System.out.println("0. Đang làm việc");
                System.out.println("1. Nghỉ việc");
                System.out.println("2. Nghỉ chế độ");
                System.out.print("Option: ");
                int choise;
                do {
                    choise = Integer.parseInt(sc.nextLine());
                    if (choise >= 0 && choise <= 2) {
                        arrEmployee[i].setEmpStatus(choise);
                        break;
                    } else {
                        System.err.println("Vui lòng chọn 1 trong 3 option trên");
                    }
                } while (isExist);
                isChecked = false;
                break;
            }
        }
        if (isChecked) {
            System.err.printf("Không tìm thấy nhân viên có mã %s\n", empIdChoise);
        } else {
            System.out.println("Nhân viên đã được cập nhật trạng thái");
        }
    }

    /**
     * Receipt Menu
     */
    static void receiptMenu() {
        boolean isExist = true;
        do {
            System.out.println("********************PRODUCT MANAGEMENT***************");
            System.out.println("1. Nhập thông tin phiếu nhập");
            System.out.println("2. Hiển thị thông tin phiếu nhập");
            System.out.println("3. Cập nhật thông tin phiếu nhập");
            System.out.println("4. Tìm phiếu nhập từ ngày đến ngày");
            System.out.println("5. Tìm phiếu nhập theo người tạo");
            System.out.println("6. Tìm phiếu nhập theo người cập nhật");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    inputDataReceipt();
                    break;
                case 2:
                    displayDataReceipt();
                    break;
                case 3:
                    updateReceipt();
                    break;
                case 4:
                    findOrderByDate();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 6 option trên");
            }
        } while (isExist);
    }

    //1. Nhập thông tin phiếu nhập
    private static void inputDataReceipt() {
        System.out.println("Nhập số lượng phiếu nhập muốn điền thông tin: ");
        int inputQuantity = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < inputQuantity; i++) {
            arrOrder[curIndexOrder] = new Order();
            System.out.printf("Phiếu nhập thứ %d: \n", curIndexOrder + 1);
            arrOrder[curIndexOrder].inputData(sc, arrProduct, curIndexProduct, arrEmployee, curIndexEmp, arrOrder, curIndexOrder, "PN", "");
            curIndexOrder++;
            System.out.println("-----------------");
        }
    }

    //2. Hiển thị thông tin phiếu nhập
    private static void displayDataReceipt() {
        System.out.println("Thông tin phiếu nhập");
        if (curIndexOrder == 0) {
            System.err.println("Hiện tại chưa có phiếu nhập");
        }
        for (int i = 0; i < curIndexOrder; i++) {
            System.out.printf("Thông tin phiếu nhập thứ %d: \n", i + 1);
            arrOrder[i].displayData();
            System.out.println("-----------------");
        }
    }

    //3. Cập nhật thông tin phiếu nhập
    private static void updateReceipt() {
        boolean isChecked = true;
        System.out.println("Nhập vào mã phiếu nhập");
        String orderIdChoise = sc.nextLine();
        for (int i = 0; i < curIndexOrder; i++) {
            if (arrOrder[i].getOrderId().equals(orderIdChoise)) {
                arrOrder[i].updateData(sc, arrProduct, curIndexProduct, arrEmployee, curIndexEmp, arrOrder, curIndexOrder, "PN", "");
                isChecked = false;
                break;
            }
        }
        if (isChecked) {
            System.err.printf("Không tìm thấy phiếu nhập nào có mã %s\n", orderIdChoise);
        } else {
            System.out.println("Phiếu nhập đã được update");
        }
    }

    //4. Tìm phiếu nhập từ ngày đến ngày
    private static void findOrderByDate() {
        int cntOrder = 0;
        boolean isChecked = true;
        System.out.print("Tìm sản phẩm từ ngày(yyyy-MM-dd): ");
        String toDate = sc.nextLine();
        try {
            //Parsing the String
            date = dateFormat.parse(toDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
            System.err.println("Nhập lại đúng định dạng yyyy-MM-dd");
        }
        String toNum = toDate.replace("-", "");
        System.out.print("Tìm sản phẩm đến ngày(yyyy-MM-dd): ");
        String fromDate = sc.nextLine();
        try {
            //Parsing the String
            date = dateFormat.parse(fromDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
            System.err.println("Nhập lại đúng định dạng yyyy-MM-dd");
        }
        String fromNum = toDate.replace("-", "");
        for (int i = 0; i < curIndexOrder; i++) {

            if (Integer.parseInt(arrOrder[i].getCreated()) >= Integer.parseInt(toNum) &&  Integer.parseInt(arrOrder[i].getCreated()) <= Integer.parseInt(fromNum)) {
                arrOrder[i].displayData();
                cntOrder++;
                isChecked = false;
            }
        }
        if (isChecked) {
            System.err.printf("Không tìm thấy phiếu nhập nào từ %s đến %s\n", toDate, fromDate);
        } else {
            System.out.printf("Đã tìm thấy %d phiếu nhập", cntOrder);
        }

    }

    //5. Tìm phiếu nhập theo người tạo
    //6. Tìm phiếu nhập theo người cập nhật

    /**
     * Bill Menu
     */
    static void billMenu() {
        boolean isExist = true;
        do {
            System.out.println("********************PRODUCT MANAGEMENT***************");
            System.out.println("1. Nhập thông tin phiếu xuất");
            System.out.println("2. Hiển thị thông tin phiếu xuất");
            System.out.println("3. Cập nhật thông tin phiếu xuất");
            System.out.println("4. Tìm phiếu xuất từ ngày đến ngày");
            System.out.println("5. Tìm phiếu xuất theo người tạo");
            System.out.println("6. Tìm phiếu xuất theo người cập nhật");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 6 option trên");
            }
        } while (isExist);

    }

    /**
     * Report Menu
     */
    static void reportMenu() {
        boolean isExist = true;
        do {
            System.out.println("********************PRODUCT MANAGEMENT***************");
            System.out.println("1. Thống kê các sản phẩm nhập từ ngày đến ngày");
            System.out.println("2. Thống kê các sản phẩm xuất từ ngày đến ngày");
            System.out.println("3. Thống kê doanh thu từ ngày đến ngày (theo các phiếu xuất)");
            System.out.println("4. Thống kê chi phí từ ngày đến ngày (theo các phiếu nhập)");
            System.out.println("5. Thống kê phiếu thu theo các tháng");
            System.out.println("6. Thống kê chi phí theo các tháng");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 6 option trên");
            }
        } while (isExist);

    }
}
