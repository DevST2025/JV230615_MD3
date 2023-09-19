package plus.entity;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private float htmlScore;
    private float cssScore;
    private float jsScore;
    private float avgScore;

    public Student() {}

    public Student(String studentId, String studentName, int age, boolean sex, float htmlScore, float cssScore, float jsScore, float avgScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.htmlScore = htmlScore;
        this.cssScore = cssScore;
        this.jsScore = jsScore;
        this.avgScore = avgScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getHtmlScore() {
        return htmlScore;
    }

    public void setHtmlScore(float htmlScore) {
        this.htmlScore = htmlScore;
    }

    public float getCssScore() {
        return cssScore;
    }

    public void setCssScore(float cssScore) {
        this.cssScore = cssScore;
    }

    public float getJsScore() {
        return jsScore;
    }

    public void setJsScore(float jsScore) {
        this.jsScore = jsScore;
    }

    public float getAvgScore() {
        return avgScore;
    }

    /**
     *
     * @param sc
     * output: void
     * function: input data for student
     * author: Tran Hong Son
     * created: 2023-09-19
     */
    public void inputData(Scanner sc) {
        System.out.print("Nhập mã SV: ");
        this.studentId = sc.nextLine();
        System.out.print("Nhập tên SV: ");
        boolean isExist = true;
        do {
            this.studentName = sc.nextLine();
            if (this.studentName.length() >= 6 &&this.studentName.length() <= 30) {
                break;
            } else {
                System.err.println("Tên SV phải gồm 6 -> 30 kí tự, vui lòng nhập lại!");
            }
        }
        while (isExist);
        System.out.print("Nhập tuổi SV: ");
        do {
            this.age = Integer.parseInt(sc.nextLine());
            if (this.age >= 18 && this.age <= 24) {
                break;
            } else {
                System.err.println("Tuổi SV phải từ 18 -> 24, vui lòng nhập lại!");
            }
        }
        while (isExist);

        System.out.print("Nhập giới tính SV: ");
        do {
            String sexString = sc.nextLine();
            if (sexString.equals("nam") || sexString.equals("nu")) {
                if (sexString.equalsIgnoreCase("nam")) {
                    sexString = "true";
                    this.sex = Boolean.parseBoolean(sexString);
                } else if (sexString.equalsIgnoreCase("nu")) {
                    sexString = "false";
                    this.sex = Boolean.parseBoolean(sexString);
                }
                break;
            } else {
                System.err.println("Vui lòng nhập \"nam\" hay \"nu\"!");
            }
        }
        while (isExist);
        System.out.print("Nhập điểm HTML của SV: ");
        do {
            this.htmlScore = Float.parseFloat(sc.nextLine());
            if (this.htmlScore >= 0 && this.htmlScore <= 10) {
                break;
            } else {
                System.err.println("Vui lòng nhập điểm từ 0 -> 10");
            }
        }
        while (isExist);
        System.out.print("Nhập điểm CSS của SV: ");
        do {
            this.cssScore = Float.parseFloat(sc.nextLine());
            if (this.cssScore >= 0 && this.cssScore <= 10) {
                break;
            } else {
                System.err.println("Vui lòng nhập điểm từ 0 -> 10");
            }
        }
        while (isExist);
        System.out.print("Nhập điểm Javascript của SV: ");
        do {
            this.jsScore = Float.parseFloat(sc.nextLine());
            if (this.jsScore >= 0 && this.jsScore <= 10) {
                break;
            } else {
                System.err.println("Vui lòng nhập điểm từ 0 -> 10");
            }
        }
        while (isExist);
    }
    public void calAvgScore() {
        this.avgScore = (this.htmlScore + this.cssScore + this.jsScore) / 3;
    }
    public void displayData() {
        System.out.printf("Mã SV: %s- Tên SV: %s- Tuổi: %d- Giới tính: %s\n", this.studentId, this.studentName, this.age, this.sex ? "Nam" : "Nữ");
        System.out.printf("Điểm HTML: %.2f- Điểm CSS: %.2f- Điểm Javascript: %.2f- Điểm trung bình: %.2f\n", this.htmlScore, this.cssScore, this.jsScore, this.avgScore);
    }
}
