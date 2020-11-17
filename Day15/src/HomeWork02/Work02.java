package HomeWork02;

import java.util.Scanner;

public class Work02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuffer str = new StringBuffer(string);
        str.reverse();
        if(string.equals(str.toString())){
            System.out.println("是回文字符");
        }else {
            System.out.println("不是回文字符");
        }
        System.out.println(str);
        System.out.println(string);

    }
}
