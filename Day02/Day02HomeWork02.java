import java.util.Scanner;

public class Day02HomeWork02 {
    public static void main(String[] args) {
        /*
         	小林子买了一筐鸡蛋，如果坏蛋少于5个，他就吃掉，否则他就去退货
         */
        System.out.println("题4----------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入坏蛋个数");
        int eggBad = scanner.nextInt();
        if(eggBad<5){
            System.out.println("吃掉");
        }else{
            System.out.println("退货");
        }


        /*
         要求用户输入两个数a、b，如果a能被b整除或a加b大于1000，则输出a，否则输出b
         */

        System.out.println("题5----------------------------");
        System.out.println("请输入两个数");
        double numA = scanner.nextDouble();
        double numB = scanner.nextDouble();
        double numC = (numA % numB == 0 || numA + numB > 1000)? numA : numB ;
        System.out.println(numC);

        /*
         	请使用条件结构/三元运算符求3个数的最值
         */
        System.out.println("题6----------------------------");
        System.out.println("请输入三个数");
        double numD = scanner.nextDouble();
        double numE = scanner.nextDouble();
        double numF = scanner.nextDouble();
        double numMax = ((  (numD>numE)?numD:numE)  >numF)?(  (numD>numE)?numD:numE)  :numF;
        double numMin = ((  (numD<numE)?numD:numE)  <numF)?(  (numD<numE)?numD:numE)  :numF;
        System.out.println("三个数中最大值为" + numMax + "最小值为" + numMin);
    }
}
