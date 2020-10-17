import java.util.Arrays;

/**
 * Int[] array = {2,432,5221,235,2,5352,1,53,5,3,5364,2,2,63,3533,2,53,532,532};
 * 求所有元素和。
 * 输出所有奇数下标元素。如：array[1]
 * 输出所有元素中，值为奇数的。
 * 将所有元素乘二。
 * 将所有元素加到第一个元素中。
 * 将奇数位置元素存到B数组中
 * 偶数元素存到C数组中
 * 分别逆序输出B数组和C数组
 */

public class Day03HomeWork06 {
    public static void main(String[] args) {
        int[] array = {2, 432, 5221, 235, 2, 5352, 1, 53, 5, 3, 5364, 2, 2, 63, 3533, 2, 53, 532, 532};
        //求所有元素和
        int sum1 = 0;
        for (int i : array) {
            sum1 += i;
        }
        System.out.println("所有元素和:" + sum1);

        //输出所有奇数下标元素
        System.out.println("所有奇数下标的:");
        for (int i = 0; i < array.length; i++) {
            if(i%2==0){
                continue;
            }
            System.out.print(array[i]+ "  ");
        }
        System.out.println();

        //输出所有元素中，值为奇数的
        System.out.println("所有值为奇数的:");
        for (int i :array){
            if(i%2!=0){
                System.out.print(i + "  ");
            }
        }
        System.out.println();

        //将所有元素乘二
        System.out.println("所有元素乘二:");
        int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i] = 2*array[i];
        }
        System.out.println(Arrays.toString(array2));

        //将所有元素加到第一个元素中
        System.out.println("将所有元素加到第一个元素中:");
        int[] array3 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array3[i] = array[i];
        }
        array3[0] = sum1;
        System.out.println(Arrays.toString(array3));

        //将奇数位置元素存到B数组中
        System.out.println("将奇数位置元素存到B数组中:");
        int longArrayB = (int)((array.length+1)/2);
        int[] arrayB = new int[longArrayB];
        for (int i = 0,j = 0; i < array.length; i++) {
            if((i+1)%2!=0){
                arrayB[j] = array[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(arrayB));

        //偶数元素存到C数组中
        System.out.println("偶数元素存到C数组中:");
        int count = 0;
        for (int i :array){
            if(i%2==0){
                count++;
            }
        }
        int[] arrayC = new int[count];
        int m = 0;
        for (int i :array){
            if(i%2==0){
                arrayC[m] = i;
                m++;
            }
        }
        System.out.println(Arrays.toString(arrayC));

        //分别逆序输出B数组和C数组
        System.out.println("逆序B数组:");
        for (int i = arrayB.length-1; i >=0 ; i--) {
            System.out.print(arrayB[i]+"  ");
        }
        System.out.println();

        System.out.println("逆序C数组:");
        for (int i = arrayC.length-1; i >=0 ; i--) {
            System.out.print(arrayC[i]+"  ");
        }
        System.out.println();



    }
}
