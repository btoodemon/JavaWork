import java.util.Arrays;

public class ArrayTest01 {
    public static void main(String[] args) {
        int[] arr1 = {2,3};
        int[][] arr2 = {{6,7},{4,3},{2,3}};
        String[] arrStr = new String[3];
        System.out.println(arrStr[0]);
        if(arrStr[0]==null){
            System.out.println("匹配成功");
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.deepToString(arr2));



        //System.out.println(Arrays.deepEquals(arr1,arr2[0]));
    }
}
