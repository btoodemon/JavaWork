
import java.util.Arrays;
import java.util.Scanner;

/**
 * 声明一个int型的数组，循环接收8个学生的成绩，
 * 计算这8个学生的总分、平均分、最高分、最低分
 */
public class Day03HomeWork03 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入学生成绩");
            arr[i] = scanner.nextInt();
            sum += arr[i];

        }


        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("总分:" + sum + "平均分:" + sum / arr.length
                + "最高分" + arr[7] + "最低分" + arr[0]);

    }
}
