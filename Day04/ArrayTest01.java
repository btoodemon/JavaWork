import java.util.Arrays;

public class ArrayTest01 {
    public static void main(String[] args) {
        int[] [] arr = new int[3][];
        arr[0] = new int[]{2, 3};
        arr[1] = new int[]{3, 7,3,4};
        arr[2] = new int[]{8,11};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }
}
