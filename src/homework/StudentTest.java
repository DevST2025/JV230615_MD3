package homework;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Nguyễn Văn A", Gender.MEN, "Jv-01", 19, "Hà Nội");
        Student student2 = new Student(2, "Nguyễn Văn B", Gender.WOMEN, "Jv-01", 20, "HCM");
        Student student3 = new Student(3, "Nguyễn Văn C", Gender.WOMEN, "Jv-01", 21, "Nha Trang");

        System.out.println("================ Information of the Student 1 =================================");
        student1.display();
        System.out.println("================ Information of the Student 2 ================================");
        student2.display();
        System.out.println("================ Information of the Student 3 ==================================");
        student3.display();
    }
}
