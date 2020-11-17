package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){

            try {
                System.out.println("输入数字");
                int a = scanner.nextInt();
                System.out.println(a);
            }catch (InputMismatchException e){
                System.out.println("您输入的不是数字");
                String s = scanner.next();
                System.out.println(s);
            }finally {
                System.out.println("finally里一定会输入执行的代码");
            }




        }





    }
}
