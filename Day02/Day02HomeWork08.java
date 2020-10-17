import java.util.Scanner;

public class Day02HomeWork08 {
    public static void main(String[] args) {

        /*
        从键盘接收一个整数N，统计出1~N之间能被7整除的整数的个数，以及这些能被7整除的数的和
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int numN = scanner.nextInt();
        int j =0 , numSum = 0;

        for(int i = 0; i<=numN ; i++){
            if(i%7==0){
                numSum += i;
                j++;

            }
        }
        System.out.println("从1到" + numN + "之间能被7整除的个数为" + j + "这些数的和为" + numSum);

    }
}
