import java.util.Arrays;

/**
 * 有一整数数组，{1,3,-1,5,-2};
 * 将数据复制到新数组中 ，要求逆序输出新数组中的数，同时并将小于0的元素按0存储
 */

public class Day03HomeWork05 {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, 5, -2};
        int[] arrN = new int[arr.length];

        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            if (arr[j] < 0) {
                arrN[i] = 0;
            } else {
                arrN[i] = arr[j];
            }
        }
        System.out.println(Arrays.toString(arrN));
    }
}
