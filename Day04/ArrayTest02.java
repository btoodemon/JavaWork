import java.util.Arrays;
    /**
    选择排序法
    selection sort
    */
public class ArrayTest02 {
    public static void main(String[] args) {
        int[] arr = {14214,123123,23523,234,323,25,34,32,432,65,643,643,6};

        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                if(min>arr[j]){

                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;

        }
        System.out.println(Arrays.toString(arr));
    }
}
