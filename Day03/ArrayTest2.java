import java.util.Scanner;

public class ArrayTest2 {
    public static void main(String[] args) {

        /*
        	有一个数列：8，4，2，1，23，344，12
        1）循环输出数列的值
        2）求数列中所有数值的和
        3）猜数游戏：从键盘中任意输入一个数据，判断数列中是否包含此数
        */

        int[] num2 = {8,4,2,1,23,344,12};
        int numSum2 = 0;
        for (int i = 0; i <num2.length; i++) {
            System.out.print(num2[i]+ "    ");
            numSum2 += num2[i];
        }
        System.out.println("总和为"+numSum2);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        int num3 = scanner.nextInt();
        for (int i = 0; i <num2.length; i++) {
            if (num3 == num2[i]){
                System.out.println("包含"+ num3);
                return;
            }



        }
        System.out.println("不包含");

    }
}
