import java.util.Scanner;

public class Day02HomeWork06 {
    public static void main(String[] args) {
        /*
        	购物管理系统生日问候
        请输入今天的日期（月/日<用两位数表示：）： 05/29
        请输入客户生日：08/09
        然后判断是否今天生日
        是否继续（y/n)
        如果是y就重复以上步骤，否则退出程序
        字符串判断相等： "05/29".equals(birthday);
        */

        Scanner scanner = new Scanner(System.in);
        String conNext;
        do{

            System.out.println("请输入今天的日期（月/日<用两位数表示：）例:05/29");
            String numToday = scanner.next();
            System.out.println("请输入客户的生日");
            String numBirthday = scanner.next();


            if(numBirthday.equals(numToday)){
                System.out.println("今天是客户的生日");
            }else {
                System.out.println("今天不是客户的生日");
            }
            System.out.println("是否继续(y/n)");
            conNext = scanner.next();

        }while ("y".equals(conNext));


    }
}
