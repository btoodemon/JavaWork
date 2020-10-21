import java.util.Arrays;

public class ArrayTest05 {
    public static void main(String[] args) {
        int[][][] ns ={
                {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 }
                },
                {
                        { 10, 11 },
                        { 12, 13 }
                },
                {
                        { 14, 15, 16 },
                        { 17, 18 }
                }
        };
        //多维数组使用Arrays.deepToString(多维数组名)  来打印
        System.out.println(Arrays.deepToString(ns));
    }
}
