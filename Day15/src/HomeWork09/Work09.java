package HomeWork09;

import java.util.Scanner;

public class Work09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件路径:(例如:C:\\hello\\image\\hello.jpg)");
        String str = scanner.nextLine();
        //C:\hello\image\hello.jpg
        int a = str.lastIndexOf("\\");
        int b = str.lastIndexOf(".");
        System.out.println("文件名: "+str.substring(a+1, b));
        System.out.println("扩展名: "+str.substring(b+1));
    }
}
