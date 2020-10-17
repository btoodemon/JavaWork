import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        //	动态录入班级人数和学员成绩，计算班级学员的平均成绩
        int stuAll = 0, numb = 0;
        Scanner scanner = new Scanner(System.in);
        String isNewNumber = "y";

        while("y".equals(isNewNumber)) {
            System.out.println("请输入学生的姓名");
            String strName = scanner.next();
            System.out.println("请输入" + strName + "的成绩");
            int stuScore = scanner.nextInt();
            stuAll += stuScore;
            numb++;
            int stuAverage = stuAll / numb;
            System.out.println(numb + "位同学的平均成绩为" + stuAverage);
            System.out.println("是否输入新的成员(y/n)");
            isNewNumber = scanner.next();
        }
    }
}
