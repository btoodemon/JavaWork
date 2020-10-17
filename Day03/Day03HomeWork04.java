import java.util.Arrays;

/**
 * 现在有如下一个数组： int[] oldArr={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
 * 要求将以上数组中的0项去掉，将不为0的值存入一个新的数组，生成新的数组为
 * Int[] newArr={1,3,4,5,6,6,5,4,7,6,7,5};
 */

public class Day03HomeWork04 {
    public static void main(String[] args) {
        int[] oldArr = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5};

        int num = 0;
        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] != 0) {
                num++;
            }
        }
        int[] newArr = new int[num];
        int num2 = 0;
        for (int temp : oldArr) {
            if (temp != 0) {
                newArr[num2] = temp;
                num2++;
            }

        }
        System.out.println(Arrays.toString(newArr));
    }
}
