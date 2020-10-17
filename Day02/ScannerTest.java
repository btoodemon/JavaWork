import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请录入学生的姓名");
        String name = input.nextLine();
        System.out.println("请录入" + name + "的成绩");
        int score = input.nextInt();
        //byte by = input.nextByte();
        //long lon = input.nextLong();
        input.nextLine();   //放置一个空的nextLine()解决
        String gender = input.nextLine();
        System.out.println(gender);
        System.out.println(name + "的成绩是" + score);

    }
}
