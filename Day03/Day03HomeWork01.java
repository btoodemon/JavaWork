import java.util.Arrays;
import java.util.Scanner;

/**
 * 在歌唱比赛中，共有10位评委进行打分，在计算歌手得分时，
 * 去掉一个最高分，去掉一个最低分，然后剩余的8位评委的分数进行平均，
 * 就是该选手的最终得分。输入每个评委的评分，求某选手的得分
 */

//方法一:求总数 再减去最大最小值
//方法二:排序 后只加中间八个
public class Day03HomeWork01 {
    public static void main(String[] args) {//方法二
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        int arrAverage = 0;

        System.out.println("请输入评分");
        for (int i = 0; i < arr.length; i++) {//输入
            arr[i] = scanner.nextInt();
        }


        for (int i = 0; i < arr.length-1; i++) {//排序
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("评分情况"+Arrays.toString(arr));
        for (int i = 1; i < arr.length-1; i++) {
            arrAverage += arr[i];
        }
        System.out.println("平均分"+arrAverage/(arr.length-2));

    }
}
