package HomeWork04;

import java.util.Scanner;

public class Work04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "E:\\jboss-4.0.4.GA\\server\\minimal\\conf\\readme.txt";
        segmentation(str);
        System.out.println("请输入:");
        //E:\SVM_space\软件工具\JDK\jdk-9_doc-api-spec-google.CHM
        segmentation(scanner.nextLine());


    }
    public static void segmentation(String str){
        System.out.println(str);
        int a = str.indexOf(":\\");
        int b = str.lastIndexOf("\\");
        int c = str.lastIndexOf(".");
        System.out.println("盘符: "+ str.substring(0, a+1));
        System.out.println("文件路径: "+ str.substring(a+2, b+1));
        System.out.println("文件名: "+ str.substring(b+1, c));
        System.out.println("文件类型: "+ str.substring(c+1));
    }
}
