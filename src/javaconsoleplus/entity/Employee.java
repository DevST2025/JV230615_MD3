package javaconsoleplus.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee {
    private int empId;
    private String empName;
    private String birthyear;
    private String phone;
    private String email;
    private int empStatus;
    SimpleDateFormat dateFrom = new SimpleDateFormat("YYYY");
    Date date = new Date();
    int year = date.getYear() + 1900;
    public Employee() {
    }

    public Employee(int empId, String empName, String birthyear, String phone, String email, int empStatus) {
        this.empId = empId;
        this.empName = empName;
        this.birthyear = birthyear;
        this.phone = phone;
        this.email = email;
        this.empStatus = empStatus;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(int empStatus) {
        this.empStatus = empStatus;
    }

    public void inputData(Scanner sc, Employee[] arrEmployee, int curIndexEmp) {
        boolean isExist = true;
        boolean isChecked = true;
        //Employee ID
        int maxId = 0;
        for (int i = 0; i < curIndexEmp; i++) {
            if (arrEmployee[i].getEmpId() > maxId) {
                maxId = arrEmployee[i].getEmpId();
            }
        }
        this.empId = maxId + 1;
        System.out.printf("Mã nhân viên: %d\n", this.empId);

        //Employee Name
        System.out.print("Nhập tên: ");
        do {
            this.empName = sc.nextLine();
            if (this.empName.length() >= 10 && this.empName.length() <= 50) {
                break;
            } else {
                System.err.println("Tên nhân viên bao gồm 10 - 50 ký tự");
            }
        } while (isExist);

        //Birth Year
        System.out.print("Nhập năm sinh: ");
        do {
            this.birthyear = sc.nextLine();
            try  {
                int empYear = Integer.parseInt(this.birthyear);
                if (this.birthyear.length() == 4) {
                    if (empYear <= year) {
                        break;
                    } else {
                        System.err.println("Vui lòng nhập năm sinh bé hơn năm hiện tại");
                    }
                } else {
                    System.err.println("Vui lòng nhập năm có 4 số");
                }

            } catch (NumberFormatException nfe) {
                System.err.println("Vui lòng nhập định dạng là số");
            }
        } while (isExist);

        //Employee Phone
        isChecked = true;
        System.out.print("Nhập số điện thoại: (+84)-");
        do {
            this.phone = sc.nextLine();
            for (int i = 0; i < curIndexEmp; i++) {
                //Remove "0" from input
                Integer inputPhone = Integer.parseInt(this.phone);
                this.phone = inputPhone.toString();
                if (arrEmployee[i].getPhone().equals(this.phone)) {
                    isChecked = false;
                    break;
                }
            }
            if (isChecked) {
                if (Pattern.matches("^0*(9|3|7|8|5)+[0-9]{8}$", this.phone)) {
                    //Remove "0" from input
                    Integer inputPhone = Integer.parseInt(this.phone);
                    this.phone = inputPhone.toString();
                    break;
                } else {
                    System.err.println("Vui lòng nhập đúng định dạng số điện thoại");
                }
            } else {
                System.err.println("Số điện thoại đã tồn tại");
                isChecked = true;
            }
        } while (isExist);

        //Employee Email
        isChecked = true;
        System.out.print("Nhập email: ");
        do {
            this.email = sc.nextLine();
            for (int i = 0; i < curIndexEmp; i++) {
                if (arrEmployee[i].getEmail().equals(this.email)) {
                    isChecked = false;
                    break;
                }
            }
            if (isChecked) {
                if (Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", this.email)) {
                    break;
                } else {
                    System.err.println("Vui lòng nhập đúng định dạng email");
                }
            } else {
                System.err.println("Email đã tồn tại");
                isChecked = true;
            }
        } while (isExist);

        //Employee Status
        System.out.println("Chọn tình trạng: ");
        System.out.println("0. Đang làm việc");
        System.out.println("1. Nghỉ việc");
        System.out.println("2. Nghỉ chế độ");
        System.out.print("Option: ");
        int choise;
        do {
            choise = Integer.parseInt(sc.nextLine());
            if (choise >= 0 && choise <= 2) {
                this.empStatus = choise;
                break;
            } else {
                System.err.println("Vui lòng chọn 1 trong 3 option trên");
            }
        } while (isExist);
    }

    public void updateData(Scanner sc, Employee[] arrEmployee, int curIndexEmp, int curIndex, String curEmpName) {
        boolean isExist = true;
        boolean isChecked = true;

        //Employee Name
        System.out.print("Nhập tên: ");
        do {
            this.empName = sc.nextLine();
            if (this.empName.isEmpty()) {
                this.empName = curEmpName;
                break;
            }
            if (this.empName.length() >= 10 && this.empName.length() <= 50) {
                break;
            } else {
                System.err.println("Tên nhân viên bao gồm 10 - 50 ký tự");
            }
        } while (isExist);

        //Birth Year
        System.out.print("Nhập năm sinh: ");
        do {
            this.birthyear = sc.nextLine();
            try  {
                int empYear = Integer.parseInt(this.birthyear);
                if (this.birthyear.length() == 4) {
                    if (empYear <= year) {
                        break;
                    } else {
                        System.err.println("Vui lòng nhập năm sinh bé hơn năm hiện tại");
                    }
                } else {
                    System.err.println("Vui lòng nhập năm có 4 số");
                }

            } catch (NumberFormatException nfe) {
                System.err.println("Vui lòng nhập định dạng là số");
            }
        } while (isExist);

        //Employee Phone
        isChecked = true;
        System.out.print("Nhập số điện thoại: (+84)-");
        do {
            this.phone = sc.nextLine();
            for (int i = 0; i < curIndexEmp; i++) {
                //Remove "0" from input
                Integer inputPhone = Integer.parseInt(this.phone);
                this.phone = inputPhone.toString();
                if (arrEmployee[i] == arrEmployee[curIndex]) {
                    continue;
                }
                if (arrEmployee[i].getPhone().equals(this.phone)) {
                    isChecked = false;
                    break;
                }
            }
            if (isChecked) {
                if (Pattern.matches("^0*(9|3|7|8|5)+[0-9]{8}$", this.phone)) {
                    //Remove "0" from input
                    Integer inputPhone = Integer.parseInt(this.phone);
                    this.phone = inputPhone.toString();
                    break;
                } else {
                    System.err.println("Vui lòng nhập đúng định dạng số điện thoại");
                }
            } else {
                System.err.println("Số điện thoại đã tồn tại");
                isChecked = true;
            }
        } while (isExist);

        //Employee Email
        isChecked = true;
        System.out.print("Nhập email: ");
        do {
            this.email = sc.nextLine();
            for (int i = 0; i < curIndexEmp; i++) {
                if (arrEmployee[i] == arrEmployee[curIndex]) {
                    continue;
                }
                if (arrEmployee[i].getEmail().equals(this.email)) {
                    isChecked = false;
                    break;
                }
            }
            if (isChecked) {
                if (Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", this.email)) {
                    break;
                } else {
                    System.err.println("Vui lòng nhập đúng định dạng email");
                }
            } else {
                System.err.println("Email đã tồn tại");
                isChecked = true;
            }
        } while (isExist);

        //Employee Status
        System.out.println("Chọn tình trạng: ");
        System.out.println("0. Đang làm việc");
        System.out.println("1. Nghỉ việc");
        System.out.println("2. Nghỉ chế độ");
        System.out.print("Option: ");
        int choise;
        do {
            choise = Integer.parseInt(sc.nextLine());
            if (choise >= 0 && choise <= 2) {
                this.empStatus = choise;
                break;
            } else {
                System.err.println("Vui lòng chọn 1 trong 3 option trên");
            }
        } while (isExist);
    }


    public void displayData() {
        String status = "Không rõ trạng thái";
        switch (this.empStatus) {
            case 0:
                status = "Đang làm việc";
                break;
            case 1:
                status = "Nghỉ việc";
                break;
            case 2:
                status = "Nghỉ chế độ";
                break;
            default:
                status = "Không rõ trạng thái";
        }
        System.out.printf("Mã: %d\n", this.empId);
        System.out.printf("Tên: %s\n", this.empName);
        System.out.printf("Năm sinh: %s\n", this.birthyear);
        System.out.printf("Số điện thoại: (+84)-%s\n", this.phone);
        System.out.printf("Email: %s\n", this.email);
        System.out.printf("Trạng thái: %s\n", status);
    }
}
