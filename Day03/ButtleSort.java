import java.util.Arrays;

/**
 * 冒泡排序:
 * 像泡泡一样从河底往上冒出来.
 * 示例 : 5,4,3,2,1
 * <p>
 * 第一趟
 * 1: 4,5,3,2,1
 * 2: 4,3,5,2,1
 * 3: 4,3,2,5,1
 * 4: 4,3,2,1,5
 * 第二趟
 * 1: 3,4,2,1,5
 * 2: 3,2,4,1,5
 * 3: 3,2,1,4,5
 * 第三趟
 * 1: 2,3,1,4,5
 * 2: 2,1,3,4,5
 * 第四趟
 * 1: 1,2,3,4,5
 */

public class ButtleSort {
    public static void main(String[] args) {
        int[] arr1 = {4, 56, 24, 1, 54, 3, 234, 456, 4, 6, 9, 3, 5, 3, 7, 2, 34, 234, 2, 5};
        for (int i = 0; i < arr1.length - 1; i++) {

            for (int j = 0; j < arr1.length - i - 1; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    int temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }

            }

        }
        System.out.println(Arrays.toString(arr1));
    }
}
