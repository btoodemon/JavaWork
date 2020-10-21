import java.util.Arrays;

/**
 * 插入排序法
 * insertion sorting
 */
public class ArrayTest03 {
    public static void main(String[] args) {
        int[] arr = {14214,123123,23523,234,323,25,34,32,432,65,643,643,6};
        for (int i = 1; i < arr.length; i++) {
            int leftIndex = i-1;
            int temp = arr[i];
            while (leftIndex >=0 && temp < arr[leftIndex]){
                arr[leftIndex+1] = arr[leftIndex];
                leftIndex--;
            }
            arr[leftIndex+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
