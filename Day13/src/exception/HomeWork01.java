package exception;


import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个整数计算除法结果");
        while (true){
            try {
                System.out.println("第一个数");
                int num1 = scanner.nextInt();
                System.out.println("第二个数");
                int num2 = scanner.nextInt();
                double result = division(num1, num2);
                System.out.println("结果是"+result);
                break;
            }catch (InputMismatchException e){
                System.out.println("请输入整数!");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("除数不能为0");
            }
        }
    }
    public static double division(int num1, int num2) throws Exception{
        double result = 0;
        try {
            result =  num1 /  num2;
            result =  (double) num1 /  (double) num2;
        }catch (Exception e){
            Exception exception = new Exception("除数不能为0!");
            throw exception;
        }
        return result;



    }
}
