package HomeWork10;

import java.util.Scanner;

public class Work10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str= "";
        while (str.length()<=6) {
            System.out.println("请输入两个字母:");
            str += scanner.nextLine();

        }
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {

            if('a'==chars[i]){
                count++;
            }
        }
        System.out.println(str);
        System.out.println("有"+count+"个a");
    }
}
