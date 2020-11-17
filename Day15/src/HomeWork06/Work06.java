package HomeWork06;

import java.util.Scanner;

public class Work06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.reverse();
        str = stringBuffer.toString();
        System.out.println(str);

    }
}
