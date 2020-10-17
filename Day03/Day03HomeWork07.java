import java.util.Arrays;
import java.util.Scanner;

/**
 * 从键盘接受10个整数保存在数组中，将10个数中最大的与第一个元素交换，
 * 最小的与最后一个元素交换，其余元素位置不变，输出数组元素的值
 * <p>
 * 1.求出最大最小值
 * 2.遍历过程中if==最大或最小,则交换
 */

public class Day03HomeWork07 {
    public static void main(String[] args) {
        System.out.println("请输入10个整数");
        int[] arr = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("输入第" + (i + 1) + "个");
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        int max = arr[0], min = arr[0];//求出最大最小值
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
            }
            if (arr[i] == min) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1];
                arr[arr.length - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
//[56, 44, 66, 88, 65, 99, 135, 2, 46, 71]
//[135, 44, 66, 88, 65, 99, 56, 71, 46, 2]