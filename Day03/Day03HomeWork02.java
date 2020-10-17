import java.util.Scanner;

/**
 * 声明一个字符串的数组，空间为5个。
 * 使用循环接收五个学生的姓名。
 * 再使用循环输出这五 个学生的姓名
 */
public class Day03HomeWork02 {
    public static void main(String[] args) {
        String[] arr = new String[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入学生的姓名");
            arr[i] = scanner.next();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print("学生姓名为:");
            System.out.println(arr[i]);
        }
    }
}
